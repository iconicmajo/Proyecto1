;;;; List short program - Amado Garcia

(defvar *list* '())
(let ((in (open "file.txt")))
	(when in
		(loop for line  = (read-line in nil) 
		while line do (push line *list*))
		(close in)
	))
	
(dolist (item *list*)
	(format t "~a~%"  item))