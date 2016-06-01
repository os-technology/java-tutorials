/**
 * 
 */
package com.eccl.product.liujian.tutorials.io;

import static java.lang.System.out;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

/**
 * @author LiuJian
 * 
 */
public class FileOperator {

	static final int MAX_BUFF_SIZE = 500 * 1000;

	/**
	 * copy file from one place to another
	 * 
	 * @param source
	 *            source file full name
	 * @param target
	 *            target file path [ name]
	 * @throws IOException
	 */
	public static void copy(String source, String target) throws IOException {
		copy(source, target, false);
	}

	/**
	 * 
	 * @param source
	 * @param target
	 * @param append
	 * @throws IOException
	 */
	public static void copy(String source, String target, boolean append)
			throws IOException {
		File srcFile = new File(source);
		File targetFile = prepareTargetFile(target);
		copy(srcFile, targetFile, append);
	}

	/**
	 * 
	 * @param source
	 * @param target
	 * @throws IOException
	 */
	public static void copy(File source, File target) throws IOException {
		copy(source, target, false);
	}

	/**
	 * 
	 * @param source
	 * @param target
	 * @param append
	 * @throws IOException
	 */
	public static void copy(File source, File target, boolean append)
			throws IOException {
		// if (!(source.exists() && source.isFile())) {
		// throw new FileNotFoundException(source.getAbsolutePath());
		// }
		//
		// if (!(target.exists() && target.isFile())) {
		// throw new FileNotFoundException(target.getAbsolutePath());
		// }

		nativeCopy(source, target, append);
	}

	public static void blizzardCopyFile(String src, String dst)
			throws IOException {
		blizzardCopyFile(src, dst, false);
	}

	public static void blizzardCopyFile(String src, String dst, boolean append)
			throws IOException {
		try (FileInputStream fis = new FileInputStream(src);
				FileOutputStream fos = new FileOutputStream(dst, append);
				FileChannel fic = fis.getChannel();) {
			fic.transferTo(0, fic.size(), fos.getChannel());
		}
	}

	/**
	 * 
	 * @param source
	 * @param target
	 * @param append
	 * @throws IOException
	 */
	private static void nativeCopy(File source, File target, boolean append)
			throws IOException {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(source));
			out = new BufferedOutputStream(new FileOutputStream(target, append));

			byte[] buf = new byte[MAX_BUFF_SIZE];
			int buffSize = 0;
			while ((buffSize = in.read(buf)) != -1) {
				out.write(buf, 0, buffSize);
			}
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} finally {
				if (out != null) {
					out.close();
				}
			}
		}
	}

	/**
	 * 
	 * @param target
	 * @return
	 * @throws IOException
	 */
	private static File prepareTargetFile(String target) throws IOException {
		return prepareTargetFile(new File(target));
	}

	/**
	 * 
	 * @param target
	 * @return
	 * @throws IOException
	 */
	private static File prepareTargetFile(File target) throws IOException {
		if (target.exists() && target.isFile()) {
			return target;
		} else if (target.isDirectory()) {
			throw new IOException("file :\" " + target.getAbsolutePath()
					+ " \" is a directory ,and it can not be written. ");
		}

		File parentFile = target.getParentFile();

		if (!parentFile.exists()) {
			if (!parentFile.mkdirs()) {
				throw new IOException("mkdir :\" "
						+ parentFile.getAbsolutePath() + " \" failed. ");
			}
		}

		if (parentFile.isDirectory()) {
			if (!target.createNewFile()) {
				throw new IOException("create file :\" "
						+ target.getAbsolutePath() + " \" failed. ");
			}
			return target;
		}

		return null;
	}

	public static void printInfo(File file) throws IOException {
		out.println("AbsolutePath :" + file.getAbsolutePath());
		out.println("exists :" + file.exists());
		out.println("name :" + file.getName());
		out.println("isFile :" + file.isFile());
		out.println("isDirectory :" + file.isDirectory());
		out.println("isAbsolute :" + file.isAbsolute());
		out.println("isHidden :" + file.isHidden());
		out.println("can execute :" + file.canExecute());
		out.println("can read :" + file.canRead());
		out.println("can write :" + file.canWrite());
		out.println("CanonicalPath :" + file.getCanonicalPath());
		out.println("FreeSpace :" + file.getFreeSpace());
		out.println("Parent :" + file.getParent());
		out.println("Path :" + file.getPath());
		out.println("TotalSpace :" + file.getTotalSpace());
		out.println("UsableSpace :" + file.getUsableSpace());
		out.println("lastModified :" + new Date(file.lastModified()));
		out.println("fileLength :" + file.length());
		out.println("pathSeparator :" + File.pathSeparator);
		out.println("separator :" + File.separator);
	}

	public static void main(String... args) throws IOException {

		String file1 = "D:\\Documents\\我的书籍\\Linux && Unix\\Linux Recipes for Oracle DBAs.pdf";
		// String file2 = "E:\\Workspaces\\java-tutorials\\file2.txt";
		String dist = "E:\\Workspaces\\java-tutorials\\a.pdf";
		String dist1 = "E:\\Workspaces\\java-tutorials\\b.pdf";
		String dist2 = "E:\\Workspaces\\java-tutorials\\c.pdf";
		Path path1 = Paths.get(file1);
		Path path2 = Paths.get(dist2);
		// File file = new File(dist);
		//
		// printInfo(file);
		long a = System.nanoTime();
		blizzardCopyFile(file1, dist);
		long b = System.nanoTime();
		copy(file1, dist1);
		long c = System.nanoTime();
		Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
		long d = System.nanoTime();
		out.printf("%d,%d,%d\n", b - a, c - b, d - c);
	}
}
