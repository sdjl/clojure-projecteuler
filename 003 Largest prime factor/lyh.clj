; 来自小旋风
(defn prime?[n]
  (if (> n 2)
      (not-any?
        #(zero? (mod n %))
        (range 2 (inc (Math/sqrt n))))
      true))

; 返回下一个比n大的质数
(defn next-prime [n]
  (loop [x n]
    (if (prime? (inc x))
        (inc x)
        (recur (inc x) ))))

; (next-prime 5)
; -> 7
; (next-prime 8)
; -> 11

; 质数序列(从2开始，依次寻找下一个质数)
; 此序列是惰性的，只有在因式分解时才会实例化，并且需要多少求多少
; (iterate f x) 传入函数f与初始值x，返回x, f(x)、f(f(x))、f(f(f(x)))....
(def primes (lazy-seq (iterate next-prime 2)))

;(take 10 primes)
; -> (2 3 5 7 11 13 17 19 23 29)

; 因式分解函数
(defn factor-seq [n]
  ; 当n大于1时，寻找n的下一个最小因数f
  (def f
    (if (> n 1)
        (some #(when (zero? (rem n %)) %) primes)))
  ; 若找到下一个因数f，表示n可被分解，返回f与n/f的因数列表
  (if f
      (cons f
            (factor-seq (/ n f)) )))

(prn (apply max (factor-seq 600851475143)))
