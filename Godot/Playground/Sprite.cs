using Godot;
using System;

public partial class Sprite : Sprite2D
{
	private int Spd = 400;
	private float AngularSpd = Mathf.Pi;
	// Called when the node enters the scene tree for the first time.
	public override void _Ready()
	{
	}

	// Called every frame. 'delta' is the elapsed time since the previous frame.
	public override void _Process(double delta)
	{
		Rotation += AngularSpd * ( float )delta;
		
		var velocity = Vector2.Up.Rotated( Rotation ) * Spd;
		
		Position += velocity * ( float )delta;
	}
	
	public Sprite()
	{
		GD.Print( "Hello, World!" );
	}
}
