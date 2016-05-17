(ns p007)
;10001st prime
;Problem 7
;By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
; we can see that the 6th prime is 13.
;What is the 10 001st prime number?
;xxf
;2016-05-07

(defn prime?[n]
  (if (> n 2)
    (not-any?
      #(zero? (mod n %))
      (range 2 (inc (Math/sqrt n))))
    true))

(defn get-prime[n]
  (if (= n 1)
    2
    (loop [p 3 i 2]
      (if (prime? p)
        (if (= i n)
          p
          (recur (+ 2 p) (inc i)))
        (recur (+ 2 p) i)))))
