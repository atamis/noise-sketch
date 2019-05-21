(ns noise-sketch.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [noise-sketch.dynamic :as dynamic])
  (:gen-class)
  )

#_(q/defsketch noise-sketch
    :title "Feel the thunder"
    :size [500 500]
  ; setup function called only once, during sketch initialization.
    :setup dynamic/setup
  ; update-state is called on each iteration before draw-state.
    :update dynamic/update-state
    :draw dynamic/draw-state
    :features [:keep-on-top]
  ; This sketch uses functional-mode middleware.
  ; Check quil wiki for more info about middlewares and particularly
  ; fun-mode.
    :middleware [m/pause-on-error m/fun-mode])

(defn -main
  [& args]
  (q/defsketch noise-sketch
    :title "Noise Sketch"
    :size [500 500]
  ; setup function called only once, during sketch initialization.
    :setup dynamic/setup
  ; update-state is called on each iteration before draw-state.
    :update dynamic/update-state
    :draw dynamic/draw-state
    :features [:keep-on-top]
    :exit-on-close true
  ; This sketch uses functional-mode middleware.
  ; Check quil wiki for more info about middlewares and particularly
  ; fun-mode.
    :middleware [m/pause-on-error m/fun-mode]))
