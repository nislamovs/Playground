
# Cleanup s3 storage

aws --endpoint-url=http://s3-storage:4566 s3 rm s3://test1 --recursive
aws --endpoint-url=http://s3-storage:4566 s3 rb s3://test1

#Create bucket

aws --endpoint-url=http://s3-storage:4566 s3 mb s3://test1

# Upload files to bucket

FILES=$(ls ./s3_files)
for file in $FILES
do
	echo "Uploading file : $file"

	aws --endpoint-url=http://s3-storage:4566 s3 sync ./s3_files s3://test1
done



