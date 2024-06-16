;;; Sierra Script 1.0 - (do not remove this comment)
(script# 24)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Feature)
(use Obj)

(public
	FixLSpeed 0
)

(local
	local0
	local1
	local2
)
(procedure (localproc_082c param1 param2)
	(param1 setLoop: param2)
)

(procedure (localproc_0837 param1 param2)
	(proc0_12)
	(= local0 0)
	(param1 setCel: 0 setLoop: param2)
)

(instance FixLSpeed of Script
	(properties)
	
	(method (init)
		(Load rsVIEW 212)
		(Load rsVIEW 65)
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
		(lp1 dispose: delete:)
		(lp2 dispose: delete:)
		(lp3 dispose: delete:)
		(lp4 dispose: delete:)
	)
	
	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(proc0_2)
				(= global193 1)
				(localproc_082c MarkHead 1)
				(= local1 1)
				(= local0 (proc255_0 24 0 67 10 25 70 100 33 600 91))
				(= seconds 10)
			)
			(1
				(localproc_0837 MarkHead 1)
				(= local1 0)
				(= seconds 4)
			)
			(2
				(proc255_0 24 1)
				(= cycles 2)
			)
			(3
				(localproc_082c MarkHead 1)
				(= local1 1)
				(= local0 (proc255_0 24 2 67 10 25 70 100 33 600 91))
				(= seconds 8)
			)
			(4
				(localproc_0837 MarkHead 1)
				(= local1 0)
				(= seconds 2)
			)
			(5
				(Scott setCel: 3)
				(ScottHead dispose:)
				(= local0 (proc255_0 24 3 67 10 25 70 100 33 600 91))
				(= seconds 4)
			)
			(6
				(proc0_12)
				(= local0 (proc255_0 24 4 67 10 25 70 100 33 600 91))
				(= seconds 8)
			)
			(7
				(proc0_12)
				(= local0 (proc255_0 24 5 67 10 25 70 100 33 600 91))
				(= seconds 8)
			)
			(8
				(proc0_12)
				(= local0 (proc255_0 24 6 67 10 25 70 100 33 600 91))
				(= seconds 6)
			)
			(9
				(proc0_12)
				(Scott setCel: 1)
				(ScottHead init:)
				(proc255_0 24 7)
				(lp1 init:)
				(lp2 init:)
				(lp3 init:)
				(lp4 init:)
				(gLongSong number: 69 loop: -1 play:)
				(= seconds 2)
			)
			(10
				(localproc_082c MarkHead 1)
				(= local1 1)
				(= local0 (proc255_0 24 8 67 10 25 70 100 33 600 91))
				(= seconds 2)
			)
			(11
				(localproc_0837 MarkHead 1)
				(= local1 0)
				(= seconds 1)
			)
			(12
				(localproc_082c ScottHead 3)
				(= local2 1)
				(= local0 (proc255_0 24 9 67 10 25 70 100 33 600 91))
				(= seconds 2)
			)
			(13
				(localproc_0837 ScottHead 3)
				(= local2 0)
				(= seconds 1)
			)
			(14
				(localproc_082c MarkHead 1)
				(= local1 1)
				(= local0 (proc255_0 24 10 67 10 25 70 100 33 600 91))
				(= seconds 2)
			)
			(15
				(localproc_0837 MarkHead 1)
				(= local1 0)
				(= seconds 5)
			)
			(16
				(proc255_0 24 11)
				(lp1 setCycle: 0)
				(lp2 setCycle: 0)
				(lp3 setCycle: 0)
				(lp4 setCycle: 0)
				(= global258 1)
				(gLongSong fade:)
				(global2 newRoom: 99)
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

(instance lp1 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 0
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

(instance lp2 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 2
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

(instance lp3 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 1
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

(instance lp4 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 3
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)
