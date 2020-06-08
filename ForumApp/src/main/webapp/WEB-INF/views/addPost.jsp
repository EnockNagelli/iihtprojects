<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
	<body>

		<div class="container">
		  <h2>Add Post</h2>
		  <form action="/addPost" class="was-validated">
		    <div class="form-group">
		      <label for="uname">Title</label>
		      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="vtitle" required>
		      <div class="valid-feedback">Valid.</div>
		      <div class="invalid-feedback">Please fill out this field.</div>
		    </div>
		    <div class="form-group">
		      <label for="tags">Tags</label>
		      <input type="text" class="form-control" id="tags" placeholder="Enter Tags" name="vtags" required>
		      <div class="valid-feedback">Valid.</div>
		      <div class="invalid-feedback">Please fill out this field.</div>
		    </div>
		    <div class="form-group">
		      <label for="posts">Post</label>
		      <textarea class="form-control" rows="15" id="post" placeholder="Enter Your Post" name="vpost" required></textarea>
		      <div class="valid-feedback">Valid.</div>
		      <div class="invalid-feedback">Please fill out this field.</div>
		    </div>
		    <button type="submit" class="btn btn-primary">Commit Post</button>
		  </form>
		</div>

	</body>
</html>