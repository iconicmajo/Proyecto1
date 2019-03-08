(defun readfile ()
   (with-open-file (infile "numeros.txt"
                              :direction :input)
       (do ((num (read infile nil 'eof) (read infile nil 'eof)))
         ((eql num 'eof) 'done)   
	;; Termina el loop y luego imprime los números que leyó. 
         (format t "~a~%" num)
       )
   )
)