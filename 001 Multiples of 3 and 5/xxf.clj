(ns p001)
;Multiples of 3 and 5
;Problem 1
;If we list all the natural numbers below 10 that are multiples of 3 or 5,
; we get 3, 5, 6 and 9. The sum of these multiples is 23.
;Find the sum of all the multiples of 3 or 5 below 1000.
;xxf
;2016-05-04

(defn multiples-sum [scope numberlist]
  (reduce
    +
    (filter
      (fn [s] (some true? (map #(zero? (rem s %)) numberlist)))
      (range 1 scope))))

(prn (multiples-sum 10 [3 5]))
(multiples-sum 1000 [3 5])

