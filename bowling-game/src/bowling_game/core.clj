(ns bowling-game.core
  (:gen-class))

(defn make-frames [pins] (partition 2 pins))

(defn score [frames next-frame]
    (let [remaining-frames (rest frames)]
		(cond
			(empty? frames) nil
			(= (reduce + (first frames)) 10) (cons (+ 10 (first next-frame)) (score remaining-frames (second remaining-frames)))
			:else (cons (reduce + (first frames)) (score remaining-frames (second remaining-frames)))
		)
	)
)

(defn rolls [pins] (let [frames (make-frames pins)] (reduce + (score frames (second frames)))))
