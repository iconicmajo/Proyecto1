;;;; Lisp simple program - Amado Garcia 

(defun sum(number1 number2)
	(format t "Sum result: ~a ~%" (+ number1 number2)))
	
(defun dif(number1 number2)
	(format t "Dif result: ~a ~%" (- number1 number2)))

(defun mult(number1 number2)
	(format t "Mult result: ~a ~%" (* number1 number2)))
	
(defun div(number1 number2)
	(format t "Divresult: ~a ~%" (/ number1 number2)))
	
(print "Write to nums to sum, dif, mult & div")
(defvar *number1* (read))
(defvar *number2* (read))
(sum *number1* *number2* ) 
(dif *number1* *number2* )
(mult *number1* *number2*)
(div *number1* *number2*) 

(print "Well done")
