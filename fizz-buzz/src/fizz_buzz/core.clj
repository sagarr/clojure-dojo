(ns fizz-buzz.core
  (:gen-class))

(defn shout [n]
		(if (zero? (rem n 3))
			"fizz"
			(if (zero? (rem n 5))
				"buzz"
				n
			)
		)
)
