(ns game-of-life.core-test
  (:require [clojure.test :refer :all]
            [game-of-life.core :refer :all]))

(deftest game-of-life-rules

  (testing "live cell dies caused by underpopulation"
           (is (= (next-state 1 1 [
                                   [0 0]
                                   [0 1]
                                   ]
                              ) 0 ; dead
                  )
               )
           )

  (testing "live cell dies caused by overcrowding"
           (is (= (next-state 1 1 [
                                   [1 1 1]
                                   [1 1 1]
                                   ]
                              ) 0 ; dead
                  )
               )
           )

  (testing "live cell with 2 neighbours lives to next generation"
           (is (= (next-state 1 1 [
                                   [1 0]
                                   [1 1]
                                   ]
                              ) 1 ; dead
                  )
               )
           )

  (testing "dead cell with 3 neighbours becomes live cell"
           (is (= (next-state 1 1 [
                                   [1 1]
                                   [1 0]
                                   ]
                              ) 1 ; dead
                  )
               )
           )
  )

(deftest game-of-life-pattern-test

  (testing "block pattern"
           (is (= (tick [[1 1] [1 1]]) [[1 1] [1 1]])))

  (testing "boat pattern"
           (is (= (tick [[0 1 1] [1 0 1] [0 1 0]])[[0 1 1] [1 0 1] [0 1 0]])))
)
