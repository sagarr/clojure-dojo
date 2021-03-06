(ns string-calculator.using-recur.core-test
  (:require [clojure.test :refer :all]
            [string-calculator.using-recur.core :refer :all]))

(deftest test-add-calculate-0-for-empty-string
  (testing "add calculated non zero for empty string"
    (is (= (add "") 0))))

(deftest test-add-calculate-number-itself-when-single-number-passed
  (testing "add not calculated number itself when single number passed"
    (is (= (add "5") 5))))

(deftest test-add-calculate-sum-when-two-numbers-passed
  (testing "add calculated sum when two numbers passed"
    (is (= (add "1, 2") 3))))
