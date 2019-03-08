;;;; Lisp Program Test, simple functions - Amado Garcia

(defvar *animals* '(Bear Ant Dog Cat))


(dolist (animal *animals*)
	(format t "~a, " animal))

(format t "~%")
	
	
(push  "RAT" *animals*)
(dolist (animal *animals*)
	(format t "~a, " animal))

(Print "Write a Message:") 
(defvar *message* (read-line))
(format t "~a" *message*)
	
