;;; Sierra Script 1.0 - (do not remove this comment)
(script# 471)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Feature)
(use Obj)

(public
	postCard 0
)

(instance postCard of Code
	(properties)
	
	(method (init)
		(Load rsVIEW 73)
		(super init:)
	)
	
	(method (doit)
		(switch global600
			(1
				(proc255_0 471 0 82 73 0 2 81 {Read Back} 1 70 100)
				(proc255_0 471 1 33 999 70 225)
			)
			(2
				(proc255_0 471 0 82 73 1 1 81 {Read Back} 1 70 100)
				(proc255_0 471 2 33 999 70 225)
			)
			(3
				(proc255_0 471 0 82 73 0 0 81 {Read Back} 1 70 100)
				(proc255_0 471 3 33 999 70 225)
			)
			(4
				(proc255_0 471 0 82 73 0 3 81 {Read Back} 1 70 100)
				(proc255_0 471 4 33 999 70 225)
			)
			(5
				(proc255_0 471 0 82 73 1 0 81 {Read Back} 1 70 100)
				(proc255_0 471 5 33 999 70 225)
			)
			(6
				(proc255_0 471 0 82 73 0 1 81 {Read Back} 1 70 100)
				(proc255_0 471 6 33 999 70 225)
			)
		)
		(DisposeScript 471)
	)
)

(instance card of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 73
			setLoop: 0
			setCel: 1
			setPri: 15
			posn: 100 53
		)
	)
)
