(ns string-calculator.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn add [s]
	(if (str/blank? s)
		0 ; then
		(if (< (read-string s) 0) ; else
			(throw (IllegalArgumentException. "hi")) ; nested then
			(reduce + (map read-string (str/split s #","))) ; nested else
		)
	)
)