(ns noise-sketch.dynamic
  (:require [quil.core :as q]
            [noise.core :as noise]
            )
  )


(defn setup []
                                        ; Set frame rate to 30 frames per second.
  (q/frame-rate 30)
                                        ; Set color mode to HSB (HSV) instead of default RGB.
  (q/color-mode :hsb)
                                        ; setup function returns initial state. It contains
                                        ; circle color and position.
  #_
  {:color 0
   :angle 0}
  0
  )

(defn update-state [state]
                                        ; Update sketch state by changing circle color and position.
  #_
  {:color (mod (+ (:color state) 0.7) 255)
   :angle (+ (:angle state) 0.1)}
  (inc state)
  )



(defn draw-state [state]
  (comment
                                        ; Clear the sketch by filling it with light-grey color.
    (q/background 240)
                                        ; Set circle color.
    (q/fill (:color state) 255 255)
                                        ; Calculate x and y coordinates of the circle.
    (let [angle (:angle state)
          dist (+ 150 (* 100 (noise/simplex (noise/new-noise-gen 0) 0 angle)))
          x (* dist (q/cos angle))
          y (* dist (q/sin angle))]
                                        ; Move origin point to the center of the sketch.
      (q/with-translation [(/ (q/width) 2)
                           (/ (q/height) 2)]
                                        ; Draw the circle.
        (q/ellipse x y 100 100))))

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
              ;; val (noise/scale val 0.0 1.0)
              blue  (q/color 0 0   255)
              green (q/color 0 255 0)
              c (q/lerp-color blue green val)
              c (if (or (q/mouse-pressed?)
                        (q/key-pressed?))
                  (q/color val 150 255)
                  (q/color val))
              ]
          (q/set-pixel img x y c))
        ))

    (q/resize img 500 0)                ; 0 means proportional
    (q/set-image 0 0 img)

    #_
    (doseq [i (range 10)]
      (let [val (noise/simplex gen i (/ state 10))
            val (* val 10)
            ]
        (q/fill 255 (* 10 val) 255)
        (q/ellipse (+ 25 (* i 50)) (+ val 250) 50 50))
      ))
  )
