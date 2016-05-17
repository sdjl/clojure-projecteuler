(ns p010)
;Summation of primes
;Problem 10
;The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;Find the sum of all the primes below two million.
;xxf
;2016-05-08

(defn prime?[n]
  (if (> n 2)
    (not-any?
      #(zero? (mod n %))
      (range 2 (inc (Math/sqrt n))))
    true))

(defn summarize-prime[scope]
  (cond
    (< scope 2) 0
    (< scope 4) 2
    :else (loop [i 3 m 2]
            (if (< i scope)
              (if (prime? i)
                (recur (+ i 2) (+ m i))
                (recur (+ i 2) m))
              m))))
(time (summarize-prime 2000000))