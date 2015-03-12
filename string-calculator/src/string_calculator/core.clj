(ns string-calculator.core
  (:require [clojure.string :as string])
  (:gen-class))

(defn first-char-number? [s] (not (nil? (re-matches (re-pattern "\\d+") (str (first s))))))

(defn add [s]
	(if (string/blank? s)
		0 ; then
		(if (= (first s) \-)
			(throw (IllegalArgumentException. "negative nos not allowed"))
			(if (first-char-number? s)
				(reduce + (map read-string (string/split s #",")))
				(reduce + (map read-string (string/split (string/replace-first s (re-pattern (str (first s))) "") (re-pattern (str (first s))))))			
			)
		)
	)
)