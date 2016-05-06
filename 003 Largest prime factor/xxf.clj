(ns p003)
;Largest prime factor
;Problem 3
;The prime factors of 13195 are 5, 7, 13 and 29.
;What is the largest prime factor of the number 600851475143 ?
;xxf
;2016-05-05

;;;;;;;;;;;;;;;;;;;;;;;;;
;too slow
;;;;;;;;;;;;;;;;;;;;;;;;;
(defn prime?[n]
  (if (> n 2)
    (not-any?
      #(zero? (mod n %))
      (range 2 (inc (Math/sqrt n))))
    true))

(defn prime-factors[n]
  (if (prime? n)
    (list n)
    (filter
      #(zero? (mod n %))
      (filter
        prime?
        (range 2 (inc (/ n 2)))))))

;(prn (prime-factors 13195))
;(prn (prime-factors 600851475143));Attention!!! I had never get answer from this command.

;;;;;;;;;;;;;;;;;;;;;;;;;
;fast version
;;;;;;;;;;;;;;;;;;;;;;;;;
(defn largest-prime-factor[numb]
  (loop [factor 2 n numb]
    (if (= n 1)
      factor;find the factor
      (if (and (> n 1) (> factor (Math/sqrt n)))
        n;it's a prime
        (if (zero? (mod n factor))
            (recur factor (/ n factor));divide the factor then continue
          (if (= factor 2)
            (recur 3 n)
            (recur (+ factor 2) n)))))))

(prn (largest-prime-factor 13195))
(largest-prime-factor 600851475143)
