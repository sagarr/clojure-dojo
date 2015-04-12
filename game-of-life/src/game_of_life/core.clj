(ns game-of-life.core
  (:gen-class))

(defn dead? [v] (= v 0))

(defn alive? [v] (= v 1))

(defn next-state [r c universe]
    (let [v (get (get universe r) c)
       neighbours-sum
       (reduce +
            (filter (complement nil?)
                (conj nil
                (get (get universe r) (inc c)) ; look in row
                (get (get universe r) (dec c)) ; look in row
                (get (get universe (inc r)) c) ; look in column
                (get (get universe (dec r)) c) ; look in column
                (get (get universe (dec r)) (dec c)) ; look diagonaly
                (get (get universe (dec r)) (inc c)) ; look diagonaly
                (get (get universe (inc r)) (dec c)) ; look diagonaly
                (get (get universe (inc r)) (inc c)) ; look diagonaly
                )
            )
      )]
      (cond
        (and (dead? v) (= 3 neighbours-sum)) 1
        (and (alive? v) (or (= 3 neighbours-sum) (= 2 neighbours-sum))) 1
        :else 0
      )
    )
)

(defn tick [universe]
    (map-indexed (fn [r value] (for [c (range (count value))] (next-state r c universe))) universe)
)

