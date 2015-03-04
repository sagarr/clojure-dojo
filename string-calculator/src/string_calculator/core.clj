(ns string-calculator.core
  (:gen-class))

(defn add [s]
	(if (clojure.string/blank? s)
		0 ; then
	(reduce + (map read-string (clojure.string/split s #","))) ; else
	)
)
