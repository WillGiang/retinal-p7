Dialog.create("set scale");
Dialog.addNumber("micron per pixel value:", 0.65);
Dialog.show();

scale_var = Dialog.getNumber();
dir_source = getDirectory("Choose source directory");
dir_output = getDirectory("Choose output directory");
list = getFileList(dir_source);

setBatchMode(true);
n = list.length;

for (i=0; i<n; i++) {
	showProgress(i+1, n);
	imagename = list[i];
	open(dir_source + imagename);
	run("Properties...", "channels=1 slices=1 frames=1 unit=micron pixel_width="+scale_var+" pixel_height="+scale_var+" voxel_depth="+scale_var);
	saveAs("tiff", dir_output+"calibrated_"+imagename);
}
