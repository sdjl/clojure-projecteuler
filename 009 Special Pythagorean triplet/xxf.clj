(ns p009)
;Special Pythagorean triplet
;Problem 9
;A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;a^2 + b^2 = c^2
;For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
;There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;Find the product abc.
;xxf
;2016-05-08

(defn pythagorean_triplet[n]
  ; assuming that a<=b
  (doseq [a (range 1 (/ n 3))]
    (doseq [b (range a (/ (- n a) 2))]
      (let [c (- n (+ a b))]
        (if (= (* c c) (+ (* a a) (* b b)))
          (prn [a b c (* a b c)]))))))

(pythagorean_triplet (+ 3 4 5))
(pythagorean_triplet 1000)
