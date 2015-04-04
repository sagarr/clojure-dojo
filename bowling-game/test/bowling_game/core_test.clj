(ns bowling-game.core-test
  (:require [clojure.test :refer :all]
            [bowling-game.core :refer :all]))

(deftest bowling-game-test
  (testing "looser game"
    (is (= (rolls (repeat 20 0)) 0))
  )

  (testing "game with each frame score is 1"
    (is (= (rolls (repeat 20 1)) 20))
  )

  (testing "game with one spare"
    (is (= (rolls (concat '(8 2 3) (repeat 17 0))) 16))
  )
)
