(ns clj-serializer.core-test
  (:use clojure.test
        clj-serializer.core)
   (:import (java.io DataOutputStream ByteArrayOutputStream
                     DataInputStream  ByteArrayInputStream)))

(def record
  {:keyword :foo
   :string "bar"
   :integer 3
   :long 52001110638799097
   :bigint 9223372036854775808
   :double 1.23
   :float (float 123/456789)
   :boolean true
   :nil nil
   :map {"hi" 9 "low" 0}
   :vector ["a" "b" "c"]
   :set #{"a" "b" "c"}
   :emptylist '()
   :list '(1 2 3)})

(deftest test-roundtrip
  (is (= record
         (deserialize (serialize record) :eof))))

(deftest test-eof-on-incomplete-bytes
  (is (= :eof
         (deserialize (byte-array (take 6 (seq (serialize "foobar")))) :eof))))

(deftest test-dos-dis-roundtrip
  (let [baos (ByteArrayOutputStream.)
        dos  (DataOutputStream. baos)]
    (dos-serialize dos :foo)
    (dos-serialize dos 2)
    (dos-serialize dos ["a" "b" "c"])
    (let [out-bytes (.toByteArray baos)
          dis   (DataInputStream. (ByteArrayInputStream. out-bytes))]
      (is (= (list :foo 2 ["a" "b" "c"])
             (dis-deserialized-seq dis))))))
