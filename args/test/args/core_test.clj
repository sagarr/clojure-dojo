(ns args.core-test
  (:require [clojure.test :refer :all]
            [args.core :refer :all]))

(deftest parse-test
  (testing "parse single boolean argument w/o value"
    (is (= (parse {:l boolean} "-l") [true])))

  (testing "parse single boolean argument w/ false value"
    (is (= (parse {:l boolean} "-l false") [false])))

  (testing "parse single boolean argument w/ true value"
    (is (= (parse {:l boolean} "-l true") [true])))

  (testing "parse single integer argument w/o value"
    (is (= (parse {:p int} "-p") [1024])))

  (testing "parse single integer argument w/ 8080 value"
    (is (= (parse {:p int} "-p 8080") [8080])))

  (testing "parse multiple argument w/o values"
    (is (= (parse {:l boolean :p int} "-l -p") '[true 1024])))

  (testing "parse multiple argument w/ values"
    (is (= (parse {:l boolean :p int} "-l false -p 8080") '[false 8080])))
)
