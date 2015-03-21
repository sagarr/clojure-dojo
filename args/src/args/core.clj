(ns args.core
  (:gen-class))

(defn default-value [type]
	(cond
		(instance? clojure.core$boolean type) true
		(instance? clojure.core$int type) 1024
	)
)

(defn parse [schema, arg]
	(let [type (schema (keyword (str (get arg 1)))) arg-len (.length arg)]
		(if (and (> arg-len 3) (not (clojure.string/blank? (subs arg 3 arg-len))))
			(read-string (subs arg 3 arg-len))
			(default-value type)
		)
	)
)
