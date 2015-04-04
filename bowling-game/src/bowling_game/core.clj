(ns bowling-game.core
  (:gen-class))


(def add (fnil + 0)) ; http://blog.jayfields.com/2011/01/clojure-fnil.html

(defn spare? [frames] (= (reduce + (first frames)) 10))

(defn strike? [frames] (= (first (first frames)) 10))

(defn score [frames next-frame]
    (let [remaining-frames (rest frames)]
        (cond
            (empty? frames) nil
            (strike? frames)
                (let [first-pin (first next-frame) second-pin (second next-frame)]
                    (cons (add second-pin (add first-pin 10)) (score remaining-frames (second remaining-frames)))
                )
            (spare? frames)
                (cons (+ 10 (first next-frame)) (score remaining-frames (second remaining-frames)))
            :else
                (cons (reduce + (first frames)) (score remaining-frames (second remaining-frames)))
        )
    )
)

(defn make-frames [pins] (partition 2 pins))

(defn rolls [pins] (let [frames (make-frames pins)] (reduce + (score frames (second frames)))))
