(ns string-calculator.core-test
  (:require [clojure.test :refer :all]
            [string-calculator.core :refer :all]))

(deftest test-add-calculate-0-for-empty-string
  (testing "add calculated non zero for empty string"
    (is (= (add "") 0))))

(deftest test-add-calculate-number-itself-when-single-number-passed
  (testing "add not calculated number itself when single number passed"
    (is (= (add "5") 5))))

(deftest test-add-calculate-sum-when-two-numbers-passed
  (testing "add calculated sum when two numbers passed"
    (is (= (add "1, 2") 3))))

(deftest test-negative-numbers-not-allowed
  (testing "negative numbers not allowed"
    (is (thrown? IllegalArgumentException (add "-1, 2")))))

(deftest test-negative-numbers-not-allowed-2
  (testing "negative numbers not allowed 2"
    (is (thrown? IllegalArgumentException (add "1, -2")))))

(deftest test-custom-delimiter
  (testing "custom delimiter"
    (is (= (add ";1;2") 3))))