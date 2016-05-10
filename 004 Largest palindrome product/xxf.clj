(ns p004)
;Largest palindrome product
;Problem 4
;A palindromic number reads the same both ways.
;The largest palindrome made from the product of two 2-digit numbers is
; 9009 = 91 × 99.
;Find the largest palindrome made from the product of two 3-digit numbers.
;xxf
;2016-05-05

(defn decompose[numb]
  (loop [n numb l '()]
    (if (< n 10)
      (conj l (int n))
      (recur (/ n 10) (conj l (int (mod n 10)))))))

(defn palindrome? [numb]
  (let [l (decompose numb)]
    (= l (reverse l))))

(defn largest-palindrome-product [n]
    (filter
      palindrome?
      (for [x (range (/ n 10) n) y (range (/ n 10) n)] (* x y))))

;about 10 seconds
(apply max (largest-palindrome-product 100))
