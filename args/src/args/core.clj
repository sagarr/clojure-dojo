(ns args.core
  (:gen-class))

(defn default-value [type]
	(cond
		(instance? clojure.core$boolean type) true
		(instance? clojure.core$int type) 1024
	)
)

(defn parse [schema, arg]
  (
	(schema (keyword (str (get arg 1))))
	(if (and (> (.length arg) 3) (not (clojure.string/blank? (subs arg 3 (.length arg))))) (read-string (subs arg 3 (.length arg)))
	(default-value (schema (keyword (str (get arg 1))))))
  )
)
