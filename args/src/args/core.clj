(ns args.core
  (:require [clojure.string :as string])
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
                    (let [
                            arg (first arg-list)
                            arg-value (nth arg 2)
                            type (schema (keyword (second arg)))
                            arg-len (.length arg-value)
                        ]
                        (if (and (> arg-len 3) (not (string/blank? arg-value)))
                            (read-string (string/trim arg-value))
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
