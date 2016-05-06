(ns p005)
;Smallest multiple
;Problem 5
;2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
;xxf
;2016-05-06

(defn get-factor[numb]
  (loop [f 2 n numb t 0 l []]
    (if (= n 1)
      (conj l t)
      (if (zero? (mod n f))
        (recur f (/ n f) (inc t) l)
        (if (= f 2)
          (recur 3 n 0 (conj l t))
          (recur (+ 2 f) n 0 (conj l t)))))))

(defn multiply-factor[list]
  (loop [f 3 n (Math/pow 2 (first list)) l (rest list)]
    (if (empty? l)
      n
      (recur (+ 2 f) (* n (Math/pow f (first l))) (rest l)))))

(defn at-least-n[list length value]
  (loop [l list]
    (if (< (count l) length)
      (recur (conj l value))
      l)))

(defn smallest-multiple[list]
  (let [length (quot (apply max list) 2)]
    (multiply-factor
      (apply map max (map #(at-least-n (get-factor %) length 0) list)))))
