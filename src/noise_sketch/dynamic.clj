(ns noise-sketch.dynamic
  (:require [quil.core :as q]
            [noise.core :as noise]))

(defn setup []
  ;; Set frame rate to 30 frames per second.
  (q/frame-rate 30)
  ;;  Set color mode to HSB (HSV) instead of default RGB.
  (q/color-mode :hsb)
  ;;  setup function returns initial state. It contains
  ;;  ;; circle color and position.
  0)

(defn update-state [state]
  ;; Update sketch state by changing circle color and position.
  (inc state))

(defn draw-state [state]
  (q/background 240)
  (let [gen (noise/new-noise-gen 0)
        width 50
        height 50
        img (q/create-image width height :rgb)]
    (dotimes [x width]
      (dotimes [y height]
        (let [val (-> (noise/simplex gen (/ x 10)
                                     (/ y 10)
                                     (/ state 20))
                      (noise/scale 0 255))
              c (if (or (q/mouse-pressed?)
                        (q/key-pressed?))
                  ;; These colors are hsb
                  (q/color val 150 255)
                  (q/color val))]
          (q/set-pixel img x y c))))

    ;; 0 means proportional
    (q/resize img 500 0)  
    (q/set-image 0 0 img)))
