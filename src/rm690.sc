;;; Sierra Script 1.0 - (do not remove this comment)
(script# 690)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm690 0
)

(instance rm690 of Rm
	(properties
		picture 690
	)
	
	(method (init &tmp [temp0 50])
		(User canInput: 1 canControl: 0)
		(super init:)
		(if (not global256) (Load rsVIEW 91) (ray init:))
		(self setScript: RayScript)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'look>')
				(cond 
					((Said '[/around,scope]') (proc255_0 690 0))
					((Said '/moon') (proc255_0 690 1))
					((Said '/beam')
						(cond 
							(global256 (proc255_0 690 2))
							(global170 (proc255_0 690 3))
							(else (proc255_0 690 4))
						)
					)
				)
			)
			((Said 'get>') (pEvent claimed: 1) (proc255_0 690 5))
		)
	)
)

(instance RayScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 5))
			(1
				(cond 
					((not global254)
						(cond 
							(global170 (proc255_0 690 6))
							(global256 (proc255_0 690 7))
							(else (proc255_0 690 8))
						)
						(gGame changeScore: 10)
					)
					(global256 (if global170 (proc255_0 690 9) else (proc255_0 690 10)))
					(global170 (proc255_0 690 11))
					(else (proc255_0 690 12))
				)
				(= global254 1)
				(= seconds 5)
			)
			(2
				(++ global593)
				(client newRoom: 69)
			)
		)
	)
)

(instance ray of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 91
			setLoop: 0
			setCel: 0
			setPri: 11
			posn: 145 85
			setCycle: Fwd
			cycleSpeed: 0
		)
	)
)
