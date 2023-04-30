USE [master]
GO
/****** Object:  Database [QuanLyXe]    Script Date: 4/30/2023 8:31:15 PM ******/
CREATE DATABASE [QuanLyXe]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyXe', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyXe.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyXe_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyXe_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QuanLyXe] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyXe].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyXe] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyXe] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyXe] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyXe] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyXe] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyXe] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QuanLyXe] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyXe] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyXe] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyXe] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyXe] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyXe] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyXe] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyXe] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyXe] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyXe] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyXe] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyXe] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyXe] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyXe] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyXe] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyXe] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyXe] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyXe] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyXe] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyXe] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyXe] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyXe] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyXe] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyXe] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyXe] SET QUERY_STORE = OFF
GO
USE [QuanLyXe]
GO
/****** Object:  Table [dbo].[ChiTietHoaDonHang]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDonHang](
	[maHDH] [varchar](20) NOT NULL,
	[maMH] [varchar](20) NOT NULL,
	[soLuong] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[maHDH] ASC,
	[maMH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHopDong]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHopDong](
	[maHD] [varchar](20) NOT NULL,
	[maCTHD] [varchar](20) NOT NULL,
	[maMH] [varchar](20) NOT NULL,
	[soLuong] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[maCTHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CuaHang]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CuaHang](
	[maCH] [varchar](20) NOT NULL,
	[tenCuaHang] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
	[sdt] [varchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maCH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonHang]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonHang](
	[maHDH] [varchar](20) NOT NULL,
	[maCH] [varchar](20) NOT NULL,
	[ngayGD] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHDH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HopDong]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HopDong](
	[maHD] [varchar](20) NOT NULL,
	[ngayLapHD] [date] NOT NULL,
	[thoiGianBH] [int] NOT NULL,
	[loaiHD] [nvarchar](50) NOT NULL,
	[maNV] [varchar](20) NOT NULL,
	[maCH] [varchar](20) NOT NULL,
	[maKH] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [varchar](20) NOT NULL,
	[tenKH] [nvarchar](100) NOT NULL,
	[gioiTinh] [nvarchar](15) NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
	[sdt] [varchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LinhKienPhuTung]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LinhKienPhuTung](
	[maLinhKien] [varchar](20) NOT NULL,
	[hangSX] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maLinhKien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MatHang]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MatHang](
	[maMH] [varchar](20) NOT NULL,
	[tenMH] [nvarchar](100) NOT NULL,
	[dvt] [nvarchar](100) NOT NULL,
	[moTa] [nvarchar](100) NOT NULL,
	[donGia] [money] NOT NULL,
	[slTon] [int] NOT NULL,
	[loaiMH] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maMH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [varchar](20) NOT NULL,
	[tenNV] [nvarchar](100) NOT NULL,
	[gioiTinh] [nvarchar](10) NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
	[sdt] [varchar](100) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[ngayVaoLam] [date] NOT NULL,
	[chucVu] [nvarchar](100) NOT NULL,
	[luongCoBan] [float] NOT NULL,
	[maCH] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NV_HanhChinh]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NV_HanhChinh](
	[maNV] [varchar](20) NOT NULL,
	[tenPB] [nvarchar](100) NOT NULL,
	[hocVan] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NV_KyThuat]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NV_KyThuat](
	[maNV] [varchar](20) NOT NULL,
	[bacTho] [nvarchar](100) NOT NULL,
	[soNamKN] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuBaoHanh]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuBaoHanh](
	[maPhieu] [varchar](20) NOT NULL,
	[maHD] [varchar](20) NOT NULL,
	[maLinhKien] [varchar](20) NOT NULL,
	[ngayBH] [date] NOT NULL,
	[liDo] [nvarchar](100) NULL,
	[loiCuaAi] [nvarchar](100) NULL,
	[giaTienSua] [money] NOT NULL,
	[maNVBH] [varchar](20) NOT NULL,
	[maKH] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[maPhieu] [varchar](20) NOT NULL,
	[tenNCC] [nvarchar](100) NULL,
	[maHDH] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuXuat]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuXuat](
	[maPhieu] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TraGop]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TraGop](
	[maHD] [varchar](20) NOT NULL,
	[ngayTra] [date] NOT NULL,
	[laiSuat] [float] NULL,
	[nguoiTra] [nvarchar](100) NULL,
	[soTienTra] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[ngayTra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TraTrucTiep]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TraTrucTiep](
	[maHD] [varchar](20) NOT NULL,
	[phanTramMienGiam] [float] NOT NULL,
	[soTienTra] [money] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Xe]    Script Date: 4/30/2023 8:31:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Xe](
	[maXe] [varchar](20) NOT NULL,
	[dongXe] [nvarchar](50) NOT NULL,
	[soKhung] [nvarchar](50) NOT NULL,
	[mauXe] [nvarchar](50) NOT NULL,
	[soPK] [int] NOT NULL,
	[soSuon] [varchar](50) NOT NULL,
	[xuatXu] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietHoaDonHang]  WITH CHECK ADD FOREIGN KEY([maHDH])
REFERENCES [dbo].[HoaDonHang] ([maHDH])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDonHang]  WITH CHECK ADD FOREIGN KEY([maMH])
REFERENCES [dbo].[MatHang] ([maMH])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHopDong]  WITH CHECK ADD FOREIGN KEY([maHD])
REFERENCES [dbo].[HopDong] ([maHD])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHopDong]  WITH CHECK ADD FOREIGN KEY([maMH])
REFERENCES [dbo].[MatHang] ([maMH])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDonHang]  WITH CHECK ADD FOREIGN KEY([maCH])
REFERENCES [dbo].[CuaHang] ([maCH])
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD FOREIGN KEY([maCH])
REFERENCES [dbo].[CuaHang] ([maCH])
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[LinhKienPhuTung]  WITH CHECK ADD FOREIGN KEY([maLinhKien])
REFERENCES [dbo].[MatHang] ([maMH])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([maCH])
REFERENCES [dbo].[CuaHang] ([maCH])
GO
ALTER TABLE [dbo].[NV_HanhChinh]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[NV_KyThuat]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PhieuBaoHanh]  WITH CHECK ADD FOREIGN KEY([maLinhKien])
REFERENCES [dbo].[LinhKienPhuTung] ([maLinhKien])
GO
ALTER TABLE [dbo].[PhieuBaoHanh]  WITH CHECK ADD FOREIGN KEY([maNVBH])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[PhieuBaoHanh]  WITH CHECK ADD FOREIGN KEY([maHD])
REFERENCES [dbo].[HopDong] ([maHD])
GO
ALTER TABLE [dbo].[PhieuBaoHanh]  WITH CHECK ADD FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD FOREIGN KEY([maHDH])
REFERENCES [dbo].[HoaDonHang] ([maHDH])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PhieuXuat]  WITH CHECK ADD FOREIGN KEY([maPhieu])
REFERENCES [dbo].[HoaDonHang] ([maHDH])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TraGop]  WITH CHECK ADD FOREIGN KEY([maHD])
REFERENCES [dbo].[HopDong] ([maHD])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TraTrucTiep]  WITH CHECK ADD FOREIGN KEY([maHD])
REFERENCES [dbo].[HopDong] ([maHD])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Xe]  WITH CHECK ADD FOREIGN KEY([maXe])
REFERENCES [dbo].[MatHang] ([maMH])
ON DELETE CASCADE
GO
USE [master]
GO
ALTER DATABASE [QuanLyXe] SET  READ_WRITE 
GO
