;;; Sierra Script 1.0 - (do not remove this comment)
(script# 96)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm096 0
)

(local
	local0
)
(procedure (localproc_04c0 &tmp temp0)
	(= temp0 (Random 1 2))
	(elmo setCel: temp0)
	(mouth setLoop: temp0 setCycle: Fwd)
	(tail init:)
)

(procedure (localproc_04ef)
	(if local0
		(tail dispose:)
		(proc0_10)
		(proc0_12)
		(= local0 0)
	)
	(elmo setCel: 0)
	(mouth setCel: 0 setLoop: 3 stopUpd:)
)

(instance rm096 of Rm
	(properties
		picture 96
	)
	
	(method (init &tmp [temp0 50])
		(Load rsVIEW 130)
		(super init:)
		(elmo init:)
		(mouth init:)
		(= global193 1)
		(Display
			96
			0
			dsCOORD
			116
			136
			dsFONT
			600
			dsWIDTH
			180
			dsCOLOR
			10
		)
		(Display
			96
			1
			dsCOORD
			112
			144
			dsFONT
			600
			dsWIDTH
			180
			dsCOLOR
			14
		)
		(Display
			96
			2
			dsCOORD
			112
			151
			dsFONT
			600
			dsWIDTH
			180
			dsCOLOR
			14
		)
		(Display
			96
			3
			dsCOORD
			105
			158
			dsFONT
			600
			dsWIDTH
			180
			dsCOLOR
			14
		)
		(Display
			96
			4
			dsCOORD
			106
			165
			dsFONT
			600
			dsWIDTH
			180
			dsCOLOR
			14
		)
		(Display
			96
			5
			dsCOORD
			106
			173
			dsFONT
			600
			dsWIDTH
			180
			dsCOLOR
			10
		)
		(proc0_2)
		(= global159 1)
		(self setScript: ElmoTalk)
	)
	
	(method (doit &tmp [temp0 50])
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if (pEvent claimed?) (return))
		(if (pEvent type?)
			(if local0 (tail dispose:) (proc0_10) (proc0_12))
			(= global193 0)
			(global2 newRoom: 120)
		)
	)
)

(instance ElmoTalk of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0 (= seconds 2))
			(1
				(localproc_04c0)
				(= local0 (proc255_0 96 6 67 -1 45 70 200 33 600 91))
				(= seconds 10)
			)
			(2
				(localproc_04ef)
				(= seconds 4)
			)
			(3
				(localproc_04c0)
				(= local0 (proc255_0 96 7 67 -1 45 70 200 33 600 91))
				(= seconds 15)
			)
			(4
				(localproc_04ef)
				(= seconds 4)
			)
			(5
				(localproc_04c0)
				(= local0 (proc255_0 96 8 67 -1 45 70 200 33 600 91))
				(= seconds 10)
			)
			(6
				(localproc_04ef)
				(= seconds 4)
			)
			(7
				(localproc_04c0)
				(= local0 (proc255_0 96 9 67 -1 45 70 200 33 600 91))
				(= seconds 10)
			)
			(8
				(localproc_04ef)
				(= seconds 4)
			)
			(9
				(localproc_04c0)
				(= local0 (proc255_0 96 10 67 -1 45 70 200 33 600 91))
				(= seconds 10)
			)
			(10 (localproc_04ef))
			(11 (global2 setScript: 0))
		)
	)
)

(instance elmo of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 130
			setLoop: 0
			setCel: 0
			posn: 163 37
			setPri: 5
			ignoreActors: 1
		)
	)
)

(instance mouth of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 130
			setLoop: 3
			setCel: 0
			posn: 163 33
			setPri: 6
			ignoreActors: 1
		)
	)
)

(instance tail of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 130
			setLoop: 4
			setCel: 0
			posn: 200 44
			setPri: 15
			ignoreActors: 1
		)
	)
)
