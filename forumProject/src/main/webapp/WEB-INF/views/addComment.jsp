<!DOCTYPE html>
<html lang="en">
<head>
  <title>Forum Application</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
	<body>
		<div class="container">
		  <h2>Add Comment</h2>
		  <form action="saveComment" class="was-validated" method=post>

		    <div class="form-group">
		      <label for="posts">Post ID</label>
		      <input type="text" class="form-control" id="postId" value="${id}" name="vpostId" required>
		      <!-- <input type="text" class="form-control" id="postId" name="vpostId" required> -->
		    </div>

		    <div class="form-group">
		      <label for="posts">Post Comment</label>
		      <textarea class="form-control" rows="7" id="comment" placeholder="Enter Your Comments" name="vcomments" required></textarea>
		      <div class="valid-feedback">Valid.</div>
		      <!-- <div class="invalid-feedback">Please fill out this field.</div> -->
		    </div>

		    <div class="form-group">
		      <label for="tags">Tags</label>
		      <input type="text" class="form-control" id="tags" placeholder="Enter Tags" name="vtags" required>
		      <div class="valid-feedback">Valid.</div>
		      <!-- <div class="invalid-feedback">Please fill out this field.</div> -->
		    </div>
		    <button type="submit" class="btn btn-primary">Commit Post</button>
		  </form>
		</div>
		<script>
			// Disable form submissions if there are invalid fields
			(function() {
			  'use strict';
			  window.addEventListener('load', function() {
			    // Get the forms we want to add validation styles to
			    var forms = document.getElementsByClassName('needs-validation');
			    // Loop over them and prevent submission
			    var validation = Array.prototype.filter.call(forms, function(form) {
			      form.addEventListener('submit', function(event) {
			        if (form.checkValidity() === false) {
			          event.preventDefault();
			          event.stopPropagation();
			        }
			        form.classList.add('was-validated');
			      }, false);
			    });
			  }, false);
			})();
		</script>

	</body>
</html>