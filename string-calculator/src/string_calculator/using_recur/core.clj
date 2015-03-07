(ns string-calculator.using-recur.core
  (require [clojure.string :as str])
  (:gen-class))

(defn str->int [s] (if (re-matches (re-pattern "\\d+") s) (read-string s)))

(defn add [s]
	(if (str/blank? s)
		0 ; then
		(do ; else
			(def i (str->int s))
			(if (number? i)
				i
				(+ (read-string (re-find #"\d+," s)) (add (str/trim (subs s (inc (.indexOf s ","))))))
			)
		)
	)
)


