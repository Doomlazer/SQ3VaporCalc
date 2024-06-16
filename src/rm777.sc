;;; Sierra Script 1.0 - (do not remove this comment)
(script# 777)
(include sci.sh)
(use Main)
(use Cycle)
(use Game)
(use Feature)

(public
	rm777 0
)

(local
	local0
)
(instance fred of Act
	(properties)
)

(instance rm777 of Rm
	(properties
		picture 777
		style $0006
	)
	
	(method (init)
		(proc0_2)
		(super init:)
		(gSounds eachElementDo: #stop)
		(while (u> (GetTime) -1024)
		)
		(fred
			view: 778
			setLoop: 0
			illegalBits: 0
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(gGame setSpeed: 0)
		(= global123 0)
	)
	
	(method (doit)
		(super doit:)
		(if (== (++ global123) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (u< local0 (GetTime))
			(cond 
				((<= global123 30) (= global124 0))
				((<= global123 60) (= global124 1))
				(else (= global124 2))
			)
			(gGame setSpeed: 5)
			(proc0_10)
			(proc0_3)
			(global2 newRoom: global125)
		)
	)
)
