(ns bowling-game.core
  (:gen-class))

(defn make-frames [pins] (partition 2 pins))

(def new+ (fnil + 0)) ; http://blog.jayfields.com/2011/01/clojure-fnil.html

(defn score [frames next-frame]
    (let [remaining-frames (rest frames)]
		(cond
			(empty? frames) nil
      (= (first (first frames)) 10)
         (let [first-pin (first next-frame) second-pin (second next-frame)] 
           (cons (new+ second-pin (new+ first-pin 10)) (score remaining-frames (second remaining-frames)))
         )         
			(= (reduce + (first frames)) 10)
         (cons (+ 10 (first next-frame)) (score remaining-frames (second remaining-frames)))
			:else 
         (cons (reduce + (first frames)) (score remaining-frames (second remaining-frames)))
		)
	)
)

(defn rolls [pins] (let [frames (make-frames pins)] (reduce + (score frames (second frames)))))
