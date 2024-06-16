;;; Sierra Script 1.0 - (do not remove this comment)
(script# 30)
(include sci.sh)
(use Main)
(use Feature)
(use Obj)

(public
	calcScript 0
)

(local
	[local0 12] = [131 142 153 164 175 186 131 142 153 164 175 186]
	[local12 9] = [54 58 61 67 71 75 79 83 87]
	[local21 9] = [58 60 64 71 75 79 83 87 91]
)
(procedure (localproc_000c param1)
	(switch param1
		(0 t1)
		(1 t2)
		(2 t3)
		(3 t4)
		(4 t5)
		(5 t6)
		(6 b1)
		(7 b2)
		(8 b3)
		(9 b4)
		(10 b5)
		(11 b6)
	)
)

(instance base of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 0
			setCel: 0
			ignoreActors: 1
			setPri: 15
			posn: 159 94
			stopUpd:
		)
	)
)

(instance t1 of Prop
	(properties)
)

(instance t2 of Prop
	(properties)
)

(instance t3 of Prop
	(properties)
)

(instance t4 of Prop
	(properties)
)

(instance t5 of Prop
	(properties)
)

(instance t6 of Prop
	(properties)
)

(instance b1 of Prop
	(properties)
)

(instance b2 of Prop
	(properties)
)

(instance b3 of Prop
	(properties)
)

(instance b4 of Prop
	(properties)
)

(instance b5 of Prop
	(properties)
)

(instance b6 of Prop
	(properties)
)

(instance calcScript of Script
	(properties)
	
	(method (init &tmp temp0)
		(= temp0 0)
		(while (< temp0 12)
			((localproc_000c temp0)
				view: 27
				setLoop: (if (< temp0 6) 1 else 2)
				setCel: [global602 temp0]
				ignoreActors: 1
				setPri: 15
				posn: [local0 temp0] (if (< temp0 6) 63 else 91)
				init:
			)
			(++ temp0)
		)
		(base init:)
	)
	
	(method (handleEvent pEvent &tmp temp0 temp1)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evMOUSEBUTTON
				(pEvent claimed: 1)
				(if
					(and
						(>= (pEvent x?) 120)
						(<= (pEvent x?) 197)
						(>= (pEvent y?) 52)
						(<= (pEvent y?) 94)
					)
					(= temp0 0)
					(while (< temp0 6)
						(if
							(and
								(>= (pEvent x?) (- [local0 temp0] 4))
								(<= (pEvent x?) (+ [local0 temp0] 4))
							)
							(= temp1 0)
							(while (< temp1 9)
								(if
									(and
										(>= (pEvent y?) [local12 temp1])
										(<= (pEvent y?) [local21 temp1])
									)
									((localproc_000c (if (< temp1 3) temp0 else (+ temp0 6)))
										setCel: (if (< temp1 3) temp1 else (- temp1 3))
									)
								)
								(++ temp1)
							)
						)
						(++ temp0)
					)
				else
					(= global252 0)
				)
			)
			(evKEYBOARD (= global252 0))
		)
	)
	
	(method (dispose &tmp temp0)
		(proc0_3)
		(= temp0 0)
		(while (< temp0 12)
			(= [global602 temp0] ((localproc_000c temp0) cel?))
			((localproc_000c temp0) dispose:)
			(++ temp0)
		)
		(base dispose:)
	)
)
