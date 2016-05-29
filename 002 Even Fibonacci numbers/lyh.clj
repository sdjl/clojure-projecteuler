; 定义了斐波那契数惰性序列
(def fibs
  ( (defn f [a b]
      (lazy-seq
        (cons (+ a b)
              (f b (+ a b)))))
    0 1))

; 我在书上看到一个斐波那契数序列的写法，感觉好帅气~
; (def fibs (lazy-cat [0 1] (map + fibs (rest fibs))))

(prn
  (apply + 
    (take-while 
      #(<= % 4000000)
      (filter even? fibs) )))
