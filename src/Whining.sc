;;; Sierra Script 1.0 - (do not remove this comment)
(script# 23)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Feature)
(use Obj)

(public
	Whining 0
)

(local
	local0
	local1
	local2
)
(procedure (localproc_045e param1 param2)
	(param1 setLoop: param2)
)

(procedure (localproc_0469 param1 param2)
	(proc0_12)
	(= local0 0)
	(param1 setCel: 0 setLoop: param2)
)

(instance Whining of Script
	(properties)
	
	(method (init)
		(Load rsVIEW 212)
		(gAddToPics add: Mark)
		(gAddToPics doit:)
		(Scott init:)
		(MarkHead init:)
		(ScottHead init:)
		(super init: &rest)
	)
	
	(method (doit)
		(if local1 (MarkHead setCel: (Random 0 4)))
		(if local2 (ScottHead setCel: (Random 0 5)))
		(super doit:)
	)
	
	(method (dispose)
		(Scott dispose: delete:)
		(MarkHead dispose: delete:)
		(ScottHead dispose: delete:)
	)
	
	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0 (= seconds 3))
			(1
				(localproc_045e ScottHead 4)
				(= local2 1)
				(= local0 (proc255_0 23 0 67 10 25 70 100 33 600 91))
				(= seconds 10)
			)
			(2
				(localproc_0469 ScottHead 3)
				(= local2 0)
				(= seconds 4)
			)
			(3
				(localproc_045e MarkHead 1)
				(= local1 1)
				(= local0 (proc255_0 23 1 67 10 25 70 100 33 600 91))
				(= seconds 10)
			)
			(4
				(localproc_0469 MarkHead 1)
				(= local1 0)
				(= seconds 4)
			)
			(5
				(localproc_045e MarkHead 1)
				(= local1 1)
				(= local0 (proc255_0 23 2 67 10 25 70 100 33 600 91))
				(= seconds 10)
			)
			(6
				(localproc_0469 MarkHead 1)
				(= local1 0)
				(= seconds 4)
			)
			(7
				(localproc_045e ScottHead 3)
				(= local2 1)
				(= local0 (proc255_0 23 3 67 10 25 70 100 33 600 91))
				(= seconds 10)
			)
			(8
				(localproc_0469 ScottHead 3)
				(= local2 0)
				(= seconds 4)
			)
			(9
				(localproc_045e MarkHead 2)
				(= local1 1)
				(= local0 (proc255_0 23 4 67 10 25 70 100 33 600 91))
				(= seconds 10)
			)
			(10
				(localproc_0469 MarkHead 1)
				(= local1 0)
				(self changeState: 0)
			)
		)
	)
)

(instance Mark of PV
	(properties
		y 109
		x 34
		view 212
		priority 15
		signal $4000
	)
)

(instance Scott of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 212
			setLoop: 0
			setCel: 1
			posn: 70 101
			setPri: 14
			ignoreActors: 1
			setCycle: 0
		)
	)
)

(instance MarkHead of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 212
			setLoop: 1
			setCel: 0
			posn: 36 109
			setPri: 14
			ignoreActors: 1
			setCycle: 0
		)
	)
)

(instance ScottHead of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 212
			setLoop: 3
			setCel: 0
			posn: 72 102
			setPri: 14
			ignoreActors: 1
			setCycle: 0
		)
	)
)
