(ns p031)
;Coin sums
;Problem 31
;In England the currency is made up of pound, £, and pence, p,
; and there are eight coins in general circulation:
;1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
;It is possible to make £2 in the following way:
;1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
;How many different ways can £2 be made using any number of coins?
;xxf
;2016-05-17

(def coins [1 2 5 10 20 50 100 200] )
(defn combines [num kk]
  (let [n num k kk]
    (cond
      (or (< k 0) (< n 0)) 0
      (= 0 n) 1
      :else (+ (combines num (- k 1)) (combines (- num (nth coins k)) k)))))

(combines 200 (- (count coins) 1))
