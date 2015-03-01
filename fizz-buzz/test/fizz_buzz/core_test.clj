(ns fizz-buzz.core-test
  (:require [clojure.test :refer :all]
            [fizz-buzz.core :refer :all]))

(deftest test-fizz
	(compare (shout 3) "fizz")
)

(deftest test-buzz
	(compare (shout 15) "buzz")
)

(deftest test-no-as-it-is
	(compare (shout 8) 8)
)