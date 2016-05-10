(println
  (apply +
    (filter
      #(or (= (mod % 3) 0) (= (mod % 5) 0)) ;3或5的整数倍过滤函数
      (range 1000)
)))
