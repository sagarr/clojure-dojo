(ns args.core
  (:gen-class))

(defn default-value [type]
	(cond
		(instance? clojure.core$boolean type) true
		(instance? clojure.core$int type) 1024
	)
)

(defn internal-parse [schema arg-list values]
	(if (or (nil? arg-list) (empty? arg-list))
		values
		(do ; else append to values
			(internal-parse schema (rest arg-list)
				(conj values
					(let [type (schema (keyword (second (first arg-list)))) arg-len (.length (nth (first arg-list) 2))]
						(if (and (> arg-len 3) (not (clojure.string/blank? (nth (first arg-list) 2))))
							(read-string (clojure.string/trim (nth (first arg-list) 2)))
							(default-value type)
						)
					)
				)
			)
		)
	)
)

(defn parse [schema arg]
	(internal-parse schema (re-seq #"-([a-z])([a-z0-9 ]*)?" arg) [])
)
