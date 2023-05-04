CREATE DATABASE QuanLyXe
go

USE QuanLyXe
go
CREATE TABLE MatHang
(
	maMH varchar(20) not null primary key,
	tenMH nvarchar(100) not null,
	dvt nvarchar(100) not null,
	moTa nvarchar(100) not null,
	donGia money not null,
	slTon int not null,
	loaiMH nvarchar(100) not null
)
go

CREATE TABLE Xe
(
	maXe varchar(20) not null primary key,
	dongXe nvarchar(50) not null,
	soKhung nvarchar(50) not null,
	mauXe nvarchar(50) not null,
	soPK int not null,
	soSuon varchar(50) not null,
	xuatXu nvarchar(100) not null,
	FOREIGN KEY(maXe) REFERENCES MatHang(maMH) on delete cascade
)
go

CREATE TABLE LinhKienPhuTung
(
	maLinhKien varchar(20) not null primary key,
	hangSX nvarchar(100) not null,
	FOREIGN KEY(maLinhKien) REFERENCES MatHang(maMH) on delete cascade
)
go

CREATE TABLE CuaHang
(
	maCH varchar(20) primary key not null,
	tenCuaHang nvarchar(50) not null,
	diaChi nvarchar(50) not null,
	sdt varchar(15) not null
)
go

CREATE TABLE NhanVien
(
	maNV varchar(20) not null primary key,
	tenNV nvarchar(100) not null,
	gioiTinh nvarchar(10) not null,
	diaChi nvarchar(100) not null,
	sdt varchar(100) not null,
	email varchar(100) not null,
	ngayVaoLam date not null,
	chucVu nvarchar(100) not null,
	luongCoBan float not null,
	maCH varchar(20) not null FOREIGN KEY REFERENCES CuaHang(maCH)
)
go

CREATE TABLE NV_HanhChinh
(
	maNV varchar(20) not null primary key,
	tenPB nvarchar(100) not null,
	hocVan nvarchar(100) not null,
	FOREIGN KEY(maNV) REFERENCES NhanVien(maNV) on delete cascade
)
go

CREATE TABLE NV_KyThuat
(
	maNV varchar(20) not null primary key,
	bacTho nvarchar(100) not null,
	soNamKN int not null,
	FOREIGN KEY(maNV) REFERENCES NhanVien(maNV) on delete cascade
)
go

CREATE TABLE KhachHang
(
	maKH varchar(20) primary key not null,
	tenKH nvarchar(100) not null,
	gioiTinh nvarchar(15) not null,
	diaChi nvarchar(100) not null,
	sdt varchar(15) not null,
)
go

CREATE TABLE HopDong
(
	maHD varchar(20) primary key not null,
	ngayLapHD date not null,
	thoiGianBH int not null,
	loaiHD nvarchar(50) not null,
	maNV varchar(20) not null FOREIGN KEY REFERENCES NhanVien(maNV) on delete cascade,
	maCH varchar(20) not null FOREIGN KEY REFERENCES CuaHang(maCH)  on delete cascade,
	maKH varchar(20) not null FOREIGN KEY REFERENCES KhachHang(maKH)  on delete cascade
)
go

CREATE TABLE TraGop
(
	maHD varchar(20) not null,
	ngayTra date not null,
	primary key(maHD, ngayTra),
	laiSuat float,
	nguoiTra nvarchar(100),
	soTienTra money,
	FOREIGN KEY(maHD) REFERENCES HopDong(maHD) on delete cascade
)
go

CREATE TABLE TraTrucTiep
(
	maHD varchar(20) not null primary key,
	phanTramMienGiam float not null,
	soTienTra money not null,
	FOREIGN KEY(maHD) REFERENCES HopDong(maHD) on delete cascade
)
go

CREATE TABLE ChiTietHopDong 
(
	maHD varchar(20) not null,
	maCTHD varchar(20) not null,
	maMH varchar(20) not null,
	soLuong int not null,
	PRIMARY KEY(maHD, maCTHD),
	FOREIGN KEY(maHD) REFERENCES HopDong(maHD) on delete cascade,
	FOREIGN KEY(maMH) REFERENCES MatHang(maMH) on delete cascade
)
go

CREATE TABLE PhieuBaoHanh
(
	maPhieu varchar(20) not null primary key,
	maHD varchar(20) not null FOREIGN KEY REFERENCES HopDong(maHD)on delete cascade,
	maLinhKien varchar(20) not null FOREIGN KEY REFERENCES LinhKienPhuTung(maLinhKien) on delete cascade,
	ngayBH date not null,
	liDo nvarchar(100),
	loiCuaAi nvarchar(100),
	giaTienSua money not null,
	maNVBH varchar(20) not null FOREIGN KEY REFERENCES NhanVien(maNV),
	maKH varchar(20) not null FOREIGN KEY REFERENCES KhachHang(maKH)  
)
go

CREATE TABLE HoaDonHang
(
	maHDH varchar(20) primary key not null,
	maCH varchar(20) not null FOREIGN KEY REFERENCES CuaHang(maCH),
	ngayGD date not null,
)
go

CREATE TABLE ChiTietHoaDonHang
(
	maHDH varchar(20) not null,
	maMH varchar(20) not null,
	soLuong int,
	PRIMARY KEY(maHDH, maMH),
	FOREIGN KEY(maHDH) REFERENCES HoaDonHang(maHDH) on delete cascade,
	FOREIGN KEY(maMH) REFERENCES MatHang(maMH) on delete cascade
)
go

CREATE TABLE PhieuNhap
(
	maPhieu varchar(20) not null primary key, 
	tenNCC nvarchar(100),
	maHDH varchar(20) not null
	FOREIGN KEY(maHDH) REFERENCES HoaDonHang(maHDH) on delete cascade
)
go

CREATE TABLE PhieuXuat
(
	maPhieu varchar(20) not null primary key,
	FOREIGN KEY(maPhieu) REFERENCES HoaDonHang(maHDH) on delete cascade
)
go

--Thêm dữ liệu cho mặt hàng
insert into MatHang values('LK001', N'Lốp xe ContiScoot 120/70-12', N'VNĐ', N'Dành cho Honda MSX 125, vision', 1230000, 7, N'Linh Kiện')
insert into MatHang values('LK002', N'Lốp Michelin City Extra', N'VNĐ', N'Phụ tùng sonic 150', 502000, 22, N'Linh Kiện')
insert into MatHang values('LK003', N'Đèn Led 2 tầng Zhi.Pat cho Suzuki', N'VNĐ', N'Đèn led', 135000, 16, N'Linh Kiện')
insert into MatHang values('LK004', N'Xinhan Spirit Beast L27', N'VNĐ', N'Dùng cho xe Exciter, Vario, MSX', 400000, 32, N'Linh Kiện')
insert into MatHang values('LK005', N'Sên vàng DID 10 ly 428HD', N'VNĐ', N'Dùng cho nhiều loại xe', 600000, 19, N'Linh Kiện')
insert into MatHang values('LK006', N'Bố thắng đĩa trước Elig', N'VNĐ', N'Dành cho xe SH', 110000, 44, N'Linh Kiện')
insert into MatHang values('LK007', N'Phuộc YSS', N'VNĐ', N'Dành cho các loại xe Honda', 700000, 35, N'Linh Kiện')
insert into MatHang values('LK008', N'Dây Curoa Michelin', N'VNĐ', N'Dành cho Vario', 594000, 54, N'Linh Kiện')
insert into MatHang values('LK009', N'Nhớt Liqui Moly Molygen 5W40', N'VNĐ', N'Dành cho nhiều loại xe', 285000, 44, N'Linh Kiện')
insert into MatHang values('LK010', N'Nhớt Repsol Racing 10W40', N'VNĐ', N'Dành cho nhiều loại xe', 280000, 39, N'Linh Kiện')
insert into MatHang values('LK011', N'Kính chiếu hậu Mview', N'VNĐ', N'Tất cả các xe', 300000, 89, N'Linh Kiện')
insert into MatHang values('LK012', N'Bộ ốc đĩa Salaya inox', N'VNĐ', N'Dành cho nhiều lọai xe', 90000, 28, N'Linh Kiện')
insert into MatHang values('X001', N'MSX 125CC', N'VNĐ', N'Sản xuất bởi Honda', 55000000,6, N'Xe')
insert into MatHang values('X002', N'SH350I', N'VNĐ', N'Sản xuất bởi Honda', 151000000,5, N'Xe')
insert into MatHang values('X003', N'SH MODE 125CC', N'VNĐ', N'Sản xuất bởi Honda', 63000000,12, N'Xe')
insert into MatHang values('X004', N'FreeGo', N'VNĐ', N'Sản xuất bởi Yamaha', 35000000,16, N'Xe')
insert into MatHang values('X005', N'Vision 2021', N'VNĐ', N'Sản xuất bởi Honda', 34900000, 19, N'Xe')
insert into MatHang values('X006', N'Vario 125', N'VNĐ', N'Sản xuất bởi Honda', 33000000, 15, N'Xe')
insert into MatHang values('X007', N'Wave Alpha 110', N'VNĐ', N'Sản xuất bởi Honda', 18400000, 20, N'Xe')
insert into MatHang values('X008', N'Wave RSX FI 110', N'VNĐ', N'Sản xuất bởi Honda', 24300000, 13, N'Xe')
insert into MatHang values('X009', N'GSX R150', N'VNĐ', N'Sản xuất bởi Suzuki', 57000000, 7, N'Xe')
insert into MatHang values('X010', N'Gixxer SF 250', N'VNĐ', N'Sản xuất bởi Suzuki', 78200000, 6, N'Xe')
insert into MatHang values('X011', N'Scrambler Sixty2', N'VNĐ', N'Sản xuất bởi Ducati', 700000000, 3, N'Xe')
insert into MatHang values('X012', N'Exciter 150', N'VNĐ', N'Sản xuất bởi Yamaha', 45800000, 14, N'Xe')
insert into MatHang values('X013', N'TNT 15', N'VNĐ', N'Sản xuất bởi Benelli', 28200000, 15, N'Xe')
insert into MatHang values('X014', N'TMAX DX 2021', N'VNĐ', N'Sản xuất bởi Yamaha', 507000000, 8, N'Xe')
insert into MatHang values('X015', N'YZF R1', N'VNĐ', N'Sản xuất bởi Yamaha', 960000000, 6, N'Xe')
insert into MatHang values('X016', N'Jupiter MX', N'VNĐ', N'Sản xuất bởi Yamaha', 30000000, 21, N'Xe')
insert into MatHang values('X017', N'MIO Z', N'VNĐ', N'Sản xuất bởi Yamaha', 25100000, 17, N'Xe')
insert into MatHang values('X018', N'XSR 155', N'VNĐ', N'Sản xuất bởi Yamaha', 58150000, 13, N'Xe')
insert into MatHang values('X019', N'Address', N'VNĐ', N'Sản xuất bởi Suzuki', 29800000, 16, N'Xe')
insert into MatHang values('X020', N'Satria F150', N'VNĐ', N'Sản xuất bởi Suzuki', 42400000, 9, N'Xe')
insert into MatHang values('X021', N'GSX 150 Bandit', N'VNĐ', N'Sản xuất bởi Suzuki', 43300000, 7, N'Xe')
insert into MatHang values('X022', N'Like 150i', N'VNĐ', N'Sản xuất bởi Kymco', 47700000, 13, N'Xe')
insert into MatHang values('X023', N'AK 550', N'VNĐ', N'Sản xuất bởi Kymco', 375000000, 2, N'Xe')
insert into MatHang values('X024', N'W175', N'VNĐ', N'Sản xuất bởi Kawasaki', 52000000, 6, N'Xe')
insert into MatHang values('X025', N'Z125 PRO', N'VNĐ', N'Sản xuất bởi Kawasaki', 61250000, 4, N'Xe')

--Thêm dữ liệu cho Xe
insert into Xe values('X001', N'Honda', N'2HNYD28898H-545659', N'Đen trắng', 125, 'UOXA-32449', N'Nhật Bản')
insert into Xe values('X002', N'Honda', N'7DAKJ18732P-784317', N'Trắng', 125, 'UOFW-65432', N'Nhật Bản')
insert into Xe values('X003', N'Honda', N'7RESD02189L-784317', N'Trắng xám', 125, 'UOFG-76321', N'Nhật Bản')
insert into Xe values('X004', N'Yamaha', N'2JGSD67892U-775245', N'Đen trắng', 120, 'DSAC-32449', N'Nhật Bản')
insert into Xe values('X005', N'Honda', N'2DASA56723O-86521', N'Đen xanh', 120, 'UORE-90237', N'Nhật Bản')
insert into Xe values('X006', N'Honda', N'1DQER67974F-876554', N'Xám đen', 125, 'UIFS-91234', N'Nhật Bản')
insert into Xe values('X007', N'Honda', N'6HNGT48451S-545659', N'Đỏ đen', 100, 'UBXF-55762', N'Nhật Bản')
insert into Xe values('X008', N'Honda', N'5DNYP85634G-923412', N'Xám đen', 110, 'UBVD-88523', N'Nhật Bản')
insert into Xe values('X009', N'Suzuki', N'8TYDK90821R-902145', N'Đỏ đen', 135, 'SUAV-68291', N'Nhật Bản')
insert into Xe values('X010', N'Suzuki', N'3HDRT27835K-744872', N'Đen xanh', 140, 'SUAV-67217', N'Nhật Bản')
insert into Xe values('X011', N'Ducati', N'9CTYD26678N-444213', N'Đen', 140, 'VDXN-22245', N'Italia')
insert into Xe values('X012', N'Yamaha', N'1DNYD24599H-432178', N'Đen trắng', 135, 'DSAX-31762', N'Nhật Bản')
insert into Xe values('X013', N'Benelli', N'5QNGA67544H-567992', N'Đen trắng', 135, 'BLHQ-55232', N'Italia')
insert into Xe values('X014', N'Yamaha', N'4NGPA43287S-676543', N'Đen xanh', 140, 'DSDG-89214', N'Nhật Bản')
insert into Xe values('X015', N'Yamaha', N'8DVER55189K-041267', N'Đỏ đen', 135, 'DSAX-66020', N'Nhật Bản')
insert into Xe values('X016', N'Yamaha', N'7LPDF92348F-779317', N'Đen trắng', 125, 'DSAB-77543', N'Nhật Bản')
insert into Xe values('X017', N'Yamaha', N'8ASHK99643C-688200', N'Xám đen', 125, 'DSLK-88921', N'Nhật Bản')
insert into Xe values('X018', N'Yamaha', N'9KQVM66542P-882137', N'Xám đen', 130, 'DSLO-99125', N'Nhật Bản')
insert into Xe values('X019', N'Suzuki', N'2KDFQ88227A-142760', N'Xám xanh', 125, 'SUTM-11767', N'Nhật Bản')
insert into Xe values('X020', N'Suzuki', N'7KXER78213Z-890279', N'Đen', 130, 'SURV-11290', N'Nhật Bản')
insert into Xe values('X021', N'Suzuki', N'4MKCB88262L-447817', N'Đỏ đen', 125, 'SUAV-78800', N'Nhật Bản')
insert into Xe values('X022', N'Kymco', N'3PASD03062K-911347', N'Trắng', 125, 'GHER-11054', N'Đài Loan')
insert into Xe values('X023', N'Kymco', N'8KTLH78943S-727143', N'Xám đen', 125, 'GHIJ-22477', N'Đài Loan')
insert into Xe values('X024', N'Honda', N'9KKER98226Y-981625', N'Xám trắng', 125, 'HGVN-56631', N'Nhật Bản')
insert into Xe values('X025', N'Honda', N'4SDAF45299T-769010', N'Đen xanh lục', 125, 'HGER-92109', N'Nhật Bản')
go
--Thêm dữ liệu cho Linh kiện phụ tùng
insert into LinhKienPhuTung values('LK001',N'Đài Loan')
insert into LinhKienPhuTung values('LK002',N'Đài Loan')
insert into LinhKienPhuTung values('LK003',N'Đức')
insert into LinhKienPhuTung values('LK004',N'Thái Lan')
insert into LinhKienPhuTung values('LK005',N'Pháp')
insert into LinhKienPhuTung values('LK006',N'Indonesia')
insert into LinhKienPhuTung values('LK007',N'Pháp')
insert into LinhKienPhuTung values('LK008',N'Nhật Bản')
insert into LinhKienPhuTung values('LK009',N'Trung Quốc')
insert into LinhKienPhuTung values('LK010',N'Nhật Bản')
insert into LinhKienPhuTung values('LK011',N'Anh')
insert into LinhKienPhuTung values('LK012',N'Nhật Bản')
go

--Thêm dữ liệu cửa hàng
insert into CuaHang values('CH001', N'CH số 1', N'112 Đường Số 1 Cxđt, Phường 4, Quận 3, TP.HCM', '0933222111')
insert into CuaHang values('CH002', N'CH số 2', N'14 Ng. 420, Đại Kim, Thanh Xuân, Hà Nội', '0933222222')
insert into CuaHang values('CH003', N'CH số 3', N'153 Trần Xuân Lê, Hòa Khê, Thanh Khê, Đà Nẵng', '0933222333')
go

--Thêm dữ liệu khách hàng
insert into KhachHang values('KH001', N'Lương Văn Tán', N'Nam', N'87, Phường 4, Quận 3, TP.HCM', '0788343289')
insert into KhachHang values('KH002', N'Trần Thị Nở', N'Nữ', N'9 Lê Ngô Cát, Võ Thị Sáu, Quận 3, TP.HCM', '0677234123')
insert into KhachHang values('KH003', N'Thái Bạch Long', N'Nam', N'54 Trường Sa, Phường 17, Bình Thạnh, TP.HCM', '0786224562')
insert into KhachHang values('KH004', N'Hứa Thị Xuân', N'Nữ', N'40B Diên Hồng, Phường 1, Bình Thạnh, TP.HCM', '0980122311')
insert into KhachHang values('KH005', N'Nguyễn Văn Phúc', N'Nam', N'52 Tổ 7 KP1, An Phú Đông, Quận 12, TP.HCM', '0455671231')
insert into KhachHang values('KH006', N'Nguyễn Văn Viên', N'Nam', N'35 An Thượng 21, Bắc Mỹ Phú, Ngũ Hành Sơn, Đà Nẵng',' 0643633577')
insert into KhachHang values('KH007', N'Nguyễn Thành Được', N'Nam', N'366P, Võ Văn Kiệt, An Hải, Q. Sơn, Đà Nẵng', '0710122625')
insert into KhachHang values('KH008', N'Trần Thị Kiều', N'Nữ', N'23 Nguyễn Công Trứ, An Hải Trung, Sơn Trà, Đà Nẵng', '0344367034')
insert into KhachHang values('KH009', N'Nguyễn Thị Lan', N'Nữ', N'17 Đ. Nguyễn Văn Cừ, Tổ 10, Long Biên, Hà Nội', '0862119927')
insert into KhachHang values('KH010', N'Kiều Minh Quang', N'Nam', N'Đức Giang, Long Biên, Hà Nội', '0926891552')
insert into KhachHang values('KH011', N'Nguyễn Văn Phong', N'Nam', N'50 Đ. Lê Văn Lương, Nhân Chính, Thanh Xuân, Hà Nội', '0224555890')
insert into KhachHang values('KH012', N'Phong Thanh Điền', N'Nam', N'số 622 Ngọc Lâm, Long Biên, Hà Nội', '0780560123')
insert into KhachHang values('KH013', N'Thái Thị Nguyệt', N'Nam', N'352 Trần Nhân Tông, TT.Vĩnh Điện, Điện Bàn, Quảng Nam', '0976020670')
insert into KhachHang values('KH014', N'Lê Thanh Nga', N'Nữ', N'2 Trần Hoành, Trường An, TP Huế, tỉnh Thừa Thiên Huế', '0901993517')
insert into KhachHang values('KH015', N'Trần Vũ Hải', N'Nam', N'45 Đoàn Trần Nghiệp, Vĩnh Phước, Nha Trang, Khánh Hòa',' 0200344677')
insert into KhachHang values('KH016', N'Nguyễn Yến Vy', N'Nữ', N'113 Đ. Trần Duy Hưng, Trung Hoà, Cầu Giấy, Hà Nội', '0912467890')
insert into KhachHang values('KH017', N'Lê Văn Tỵ', N'Nam', N'4 Cao Thắng, Hàm Thuận Bắc, TP.Phan Thiết, Bình Thuận', '0698223451')
insert into KhachHang values('KH018', N'Trần Thị Ngọc', N'Nữ', N'94V4+34J, Phường Thống Nhất, TP.Vũng Tàu, BR-VT', '0976551890')
insert into KhachHang values('KH019', N'Lê Gia Bảo', N'Nam', N'193 Đ. Bùi Văn Hòa, Long Bình, TP.Biên Hòa, Đồng Nai', '0875223476')
insert into KhachHang values('KH020', N'Vũ Ngọc Tiệp', N'Nam', N'75/744F Đ. Nguyễn Văn Nghi, Phường 7, Gò Vấp, TP.HCM', '0433491275')
go

--Thêm dữ liệu nhân viên
insert into NhanVien values('NV001',N'Trần Văn Sơn', N'Nam', N'Ấp 6, Hòa Hiệp, Xuyên Mộc, BR-VT', '0933900911', 'vanSon122@gmail.com', '2023-2-5 08:00:00.000', N'Nhân viên bán hàng',3728000, 'CH001')
insert into NhanVien values('NV002',N'Lê Hương Trà', N'Nữ', N'Số 2/16, hẻm 2, Bạch Đằng, Tân Bình, TP.HCM', '0822911911', 'tra1996@gmail.com', '2020-7-7 09:00:00.000', N'Nhân viên tư vấn/Bảo hành',4500000, 'CH001')
insert into NhanVien values('NV003',N'Vũ Như Hà',  N'Nữ', N'Số 207, đường Phạm Văn Đồng, phường 3, Gò Vấp, TP.HCM', '0826812977', 'nHa789@gmail.com', '2021-7-30 14:00:00.000', N'Kế toán',4000000, 'CH001')
insert into NhanVien values('NV004',N'Trần Thị Thu',  N'Nữ', N'162/38 Phan Đăng Lưu, Phường 3, Phú Nhuận, TP.HCM', '0344610610', 'TThu110@gmail.com', '2019-12-11 07:00:00.000', N'Kế toán',6000000, 'CH001')
insert into NhanVien values('NV005',N'Nguyễn Thái Vỹ', N'Nam', N'339 Đ. Lê Văn Sỹ, Phường 13, Quận 3, TP.HCM', '0211900922', 'thaiVy12@gmail.com', '2019-2-9 07:00:00.000', N'Nhân viên bán hàng',5200000, 'CH001')
insert into NhanVien values('NV006',N'Phạm Vũ Luân', N'Nam', N'6/1B QL1A, Phường Linh Trung, Thủ Đức, TP.HCM', '0722421333', 'Luan223@gmail.com', '2022-1-9 07:30:00.000', N'Nhân viên tư vấn/Bảo hành',4350000, 'CH001')
insert into NhanVien values('NV007',N'Lê Thanh Hải', N'Nam', N'492 Nguyễn Trãi, Lái Thiêu, Thuận An, Bình Dương', '0711500511', 'THai34@gmail.com', '2019-12-19 07:00:00.000', N'Quản lý kho hàng',4900000, 'CH001')
insert into NhanVien values('NV008',N'Nguyễn Thị Thu Hà',  N'Nữ', N'19 Trần Văn Việt, Thường Thạnh, Cái Răng, Cần Thơ', '0877655622', 'ttHa677@gmail.com', '2019-12-15 08:00:00.000', N'Nhân viên bán hàng',6200000, 'CH001')
insert into NhanVien values('NV009',N'Vũ Thị Hồng',  N'Nữ', N'18 Lê Văn Duyệt, Trà Ôn, Vĩnh Long', '0777123633', 'Hong55@gmail.com', '2022-2-5 08:00:00.000', N'Quản lý kho hàng',4400000, 'CH001')
insert into NhanVien values('NV010',N'Đặng Thành Nam', N'Nam', N'TT. Phú Mỹ, Tân Thành, BR-VT', '0788322112', 'Nam333@gmail.com', '2021-3-15 07:00:00.000', N'Nhân viên bán hàng',4600000, 'CH001')
insert into NhanVien values('NV011',N'Vũ Như Thành', N'Nam', N'188 Hùng Vương, Hải Châu 2, Hải Châu, Đà Nẵng', '0909678365', 'nhuThanh1@gmail.com', '2023-1-3 07:00:00.000', N'Nhân viên bán hàng',3728000, 'CH002')
insert into NhanVien values('NV012',N'Trần Hương Giang', N'Nữ', N'32 Nguyễn Đôn Tiết, Thuận Phước, Hải Châu, Đà Nẵng', '0822766251', 'HGiang47@gmail.com', '2020-3-4 07:00:00.000', N'Nhân viên tư vấn/Bảo hành',4500000, 'CH002')
insert into NhanVien values('NV013',N'Lê Ánh Hoa', N'Nữ', N'85 Nguyễn Du, Thạch Thang, Hải Châu, Đà Nẵng', '0214563423', 'AHoa869@gmail.com', '2019-11-23 16:00:00.000', N'Kế toán',7000000, 'CH002')
insert into NhanVien values('NV014',N'Võ Thị Nguyệt', N'Nữ', N'210 Bạch Đằng, Phước Ninh, Hải Châu, Đà Nẵng', '0344432980', 'TNguyet001@gmail.com', '2019-9-21 08:00:00.000', N'Quản lý kho hàng',6000000, 'CH002')
insert into NhanVien values('NV015',N'Ngyễn Thị Hải', N'Nữ', N'121 Hùng Vương, Hải Châu 2, Hải Châu, Đà Nẵng', '0665332178', 'thiHai10@gmail.com', '2019-9-4 07:00:00.000', N'Nhân viên bán hàng',5200000, 'CH002')
insert into NhanVien values('NV016',N'Lê Văn Thế', N'Nam', N'Thanh Nhàn, Hai Bà Trưng, Hà Nội', '0793729102', 'vanThe09@gmail.com', '2022-11-19 08:30:00.000', N'Nhân viên tư vấn/Bảo hành',4350000, 'CH003')
insert into NhanVien values('NV017',N'Tôn Thanh Sơn', N'Nam', N'30 P. Hương Viên, Đồng Nhân, Hai Bà Trưng, Hà Nội', '0810302490', 'tSon76@gmail.com', '2019-4-30 08:00:00.000', N'Nhân viên bán hàng',4900000, 'CH003')
insert into NhanVien values('NV018',N'Nguyễn Thị Mai', N'Nữ', N'Quán Thánh, Ba Đình, Hà Nội', '0855189040', 'tMai07@gmail.com', '2019-8-9 08:00:00.000', N'Kế toán',6300000, 'CH003')
insert into NhanVien values('NV019',N'Vũ Thị Kim', N'Nữ', N'192 Lê Trọng Tấn, Khương Mai, Thanh Xuân, Hà Nội', '0823115900', 'tKim56@gmail.com', '2022-10-25 07:00:00.000', N'Quản lý kho hàng',4400000, 'CH003')
insert into NhanVien values('NV020',N'Cù Chính Văn', N'Nam', N'90 Đ. Nguyễn Tuân, Thanh Xuân Trung, Thanh Xuân, Hà Nội', '0455622199', 'chinhVan60@gmail.com', '2020-12-15 07:00:00.000', N'Nhân viên bán hàng',4900000, 'CH003')
insert into NhanVien values('NV021',N'Nguyễn Tiến Lợi', N'Nam', N'12 Lê Văn Duyệt, Trà Ôn, Vĩnh Long', '0663123623', 'tLoi697@gmail.com', '2023-1-2 08:00:00.000', N'Nhân viên kỹ thuật',3800000, 'CH001')
insert into NhanVien values('NV022',N'Lê Văn Vũ', N'Nam', N'số 330 Đ. Lê Văn Sỹ, Phường 13, Quận 3, TP.HCM', '0322378655', 'vVu221@gmail.com', '2022-2-5 07:00:00.000', N'Nhân viên kỹ thuật',4400000, 'CH001')
insert into NhanVien values('NV023',N'Nguyễn Thành Kỳ', N'Nam', N'Phường 9, Quận 3, TP.HCM', '0999234123', 'TKy45@gmail.com', '2019-6-5 07:00:00.000', N'Nhân viên kỹ thuật',6400000, 'CH001')
insert into NhanVien values('NV024',N'Trần Thái Bảo', N'Nam', N'964 Đ. Trường Sa, Phường 13, Quận 3, TP.HCM', '0956274923', 'tBao88@gmail.com', '2020-8-22 06:00:00.000', N'Nhân viên kỹ thuật',5600000, 'CH001')
insert into NhanVien values('NV025',N'Võ Văn Công', N'Nam', N'27 Hẻm 66 Phan Sào Nam, Phường 11, Tân Bình, TP.HCM', '0665455677', 'vanCong@gmail.com', '2021-12-5 07:00:00.000', N'Nhân viên kỹ thuật',5900000, 'CH001')
insert into NhanVien values('NV026',N'Dương Chí Thành', N'Nam', N'28 thôn 2, Kim Lan, Gia Lâm, Hà Nội', '0755908102', 'chiThanh98@gmail.com', '2021-1-15 07:40:00.000', N'Nhân viên kỹ thuật',6000000, 'CH002')
insert into NhanVien values('NV027',N'Trương Quang Nghĩa', N'Nam', N'34 Ng. 1 P. Phan Đình Giót, Phương Liệt, Thanh Xuân, Hà Nội', '0277671221', 'QNghia123@gmail.com', '2019-11-5 06:30:00.000', N'Nhân viên kỹ thuật',7600000, 'CH002')
insert into NhanVien values('NV028',N'Lê Văn Thành', N'Nam', N'194 P. Trần Đại Nghĩa, Đồng Tâm, Hai Bà Trưng, Hà Nội', '0445245209', 'vThanh442@gmail.com', '2020-3-9 07:00:00.000', N'Nhân viên kỹ thuật',6600000, 'CH002')
insert into NhanVien values('NV029',N'Nguyễn Đức Độ', N'Nam', N'175 Nguyễn Giản Thanh, An Khê, Thanh Khê, Đà Nẵng', '0652888010', 'DDo220@gmail.com', '2019-6-6 08:00:00.000', N'Nhân viên kỹ thuật',7400000, 'CH003')
insert into NhanVien values('NV030',N'Dương Công Danh', N'Nam', N'Bầu năng 12, Liên Chiểu, Đà Nẵng', '0665455677', 'cDanh489@gmail.com', '2020-12-10 09:00:00.000', N'Nhân viên kỹ thuật',6200000, 'CH003')
go

--Thêm dữ liệu nhân viên hành chính
insert into NV_HanhChinh values('NV001','PB 1','Đại học')
insert into NV_HanhChinh values('NV002','PB 1','Đại học')
insert into NV_HanhChinh values('NV003','PB 1','Đại học')
insert into NV_HanhChinh values('NV004','PB 2','Đại học')
insert into NV_HanhChinh values('NV005','PB 2','Đại học')
insert into NV_HanhChinh values('NV006','PB 2','Đại học')
insert into NV_HanhChinh values('NV007','PB 1','Đại học')
insert into NV_HanhChinh values('NV008','PB 1','Đại học')
insert into NV_HanhChinh values('NV009','PB 2','Đại học')
insert into NV_HanhChinh values('NV010','PB 2','Đại học')
insert into NV_HanhChinh values('NV011','PB 3','Đại học')
insert into NV_HanhChinh values('NV012','PB 3','Đại học')
insert into NV_HanhChinh values('NV013','PB 4','Đại học')
insert into NV_HanhChinh values('NV014','PB 4','Đại học')
insert into NV_HanhChinh values('NV015','PB 4','Đại học')
insert into NV_HanhChinh values('NV016','PB 5','Đại học')
insert into NV_HanhChinh values('NV017','PB 5','Đại học')
insert into NV_HanhChinh values('NV018','PB 5','Đại học')
insert into NV_HanhChinh values('NV019','PB 6','THPT')
insert into NV_HanhChinh values('NV020','PB 6','Đại học')

--Thêm dữ liệu nhân viên kĩ thuật
insert into NV_KyThuat values('NV021',N'Bậc 1',1)
insert into NV_KyThuat values('NV022',N'Bậc 2',3)
insert into NV_KyThuat values('NV023',N'Bậc 3',6)
insert into NV_KyThuat values('NV024',N'Bậc 4',9)
insert into NV_KyThuat values('NV025',N'Bậc 5',17)
insert into NV_KyThuat values('NV026',N'Bậc 6',21)
insert into NV_KyThuat values('NV027',N'Bậc 2',4)
insert into NV_KyThuat values('NV028',N'Bậc 2',3)
insert into NV_KyThuat values('NV029',N'Bậc 1',2)
insert into NV_KyThuat values('NV030',N'Bậc 5',16)
go
--Thêm dữ liệu hợp đồng
insert into HopDong values('HD001', '2021-12-16 11:00:00.000', 12, N'Trả trực tiếp', 'NV010', 'CH001', 'KH002')
insert into HopDong values('HD002', '2020-9-8 08:00:00.000', 24,N'Trả trực tiếp', 'NV005', 'CH001', 'KH005')
insert into HopDong values('HD003', '2021-3-4 15:00:00.000', 24, N'Trả trực tiếp', 'NV001', 'CH001', 'KH003')
insert into HopDong values('HD004', '2019-12-28 12:00:00.000', 12, N'Trả trực tiếp', 'NV008', 'CH001', 'KH004')
insert into HopDong values('HD005', '2020-9-5 16:00:00.000', 36, N'Trả trực tiếp', 'NV010', 'CH001', 'KH020')
insert into HopDong values('HD006', '2022-11-1 18:00:00.000', 18, N'Trả trực tiếp', 'NV008', 'CH001', 'KH001')
insert into HopDong values('HD007', '2022-10-21 13:00:00.000', 12, N'Trả trực tiếp', 'NV005', 'CH001', 'KH003')
insert into HopDong values('HD008', '2021-4-15 7:00:00.000', 18, N'Trả trực tiếp', 'NV001', 'CH001', 'KH018')
insert into HopDong values('HD009', '2021-9-9 10:00:00.000', 18, N'Trả trực tiếp', 'NV010', 'CH001', 'KH017')
insert into HopDong values('HD010', '2022-2-18 9:00:00.000', 12, N'Trả góp', 'NV001', 'CH001', 'KH019')
insert into HopDong values('HD011', '2020-11-26 19:00:00.000', 12, N'Trả trực tiếp', 'NV011', 'CH002', 'KH009')
insert into HopDong values('HD012', '2021-11-3 16:00:00.000', 18, N'Trả trực tiếp', 'NV011', 'CH002', 'KH011')
insert into HopDong values('HD013', '2022-7-4 14:00:00.000', 12, N'Trả trực tiếp', 'NV015', 'CH002', 'KH010')
insert into HopDong values('HD014', '2023-2-2 11:00:00.000', 24, N'Trả trực tiếp', 'NV011', 'CH002', 'KH014')
insert into HopDong values('HD015', '2020-9-19 12:00:00.000', 24, N'Trả trực tiếp', 'NV015', 'CH002', 'KH016')
insert into HopDong values('HD016', '2021-5-20 13:00:00.000', 12, N'Trả góp', 'NV011', 'CH002', 'KH009')
insert into HopDong values('HD017', '2021-7-7 7:00:00.000', 24, N'Trả trực tiếp', 'NV015', 'CH002', 'KH012')
insert into HopDong values('HD018', '2022-12-8 12:00:00.000', 12, N'Trả trực tiếp', 'NV020', 'CH003', 'KH006')
insert into HopDong values('HD019', '2020-11-24 10:50:00.000', 24, N'Trả trực tiếp', 'NV020', 'CH003', 'KH007')
insert into HopDong values('HD020', '2021-11-15 14:00:00.000', 18, N'Trả trực tiếp', 'NV017', 'CH003', 'KH008')
insert into HopDong values('HD021', '2020-9-15 9:00:00.000', 30, N'Trả trực tiếp','NV020', 'CH003', 'KH015')
insert into HopDong values('HD022', '2020-12-1 8:40:00.000', 18, N'Trả trực tiếp', 'NV017', 'CH003', 'KH013')
insert into HopDong values('HD023', '2021-12-5 10:30:00.000', 36, N'Trả góp', 'NV017', 'CH003', 'KH014')
insert into HopDong values('HD024', '2020-2-4 15:00:00.000', 12, N'Trả góp', 'NV020', 'CH003', 'KH006')
insert into HopDong values('HD025', '2021-9-4 17:00:00.000', 12, N'Trả góp', 'NV017', 'CH003', 'KH007')
go

--Thêm dữ liệu chi tiết hợp đồng
insert into ChiTietHopDong values('HD001', 'CTHD001', 'x002', 1)
insert into ChiTietHopDong values('HD001', 'CTHD002', 'x004', 3)
insert into ChiTietHopDong values('HD002', 'CTHD003', 'x006', 1)
insert into ChiTietHopDong values('HD003', 'CTHD004', 'x007', 1)
insert into ChiTietHopDong values('HD003', 'CTHD005', 'x008', 1)
insert into ChiTietHopDong values('HD004', 'CTHD006', 'x011', 1)
insert into ChiTietHopDong values('HD005', 'CTHD007', 'x012', 1)
insert into ChiTietHopDong values('HD006', 'CTHD008', 'x014', 1)
insert into ChiTietHopDong values('HD007', 'CTHD009', 'x005', 1)
insert into ChiTietHopDong values('HD008', 'CTHD010', 'x009', 2)
insert into ChiTietHopDong values('HD009', 'CTHD011', 'x016', 2)
insert into ChiTietHopDong values('HD010', 'CTHD012', 'x017', 1)
insert into ChiTietHopDong values('HD011', 'CTHD013', 'x018', 1)
insert into ChiTietHopDong values('HD012', 'CTHD014', 'x020', 5)
insert into ChiTietHopDong values('HD013', 'CTHD015', 'x025', 1)
insert into ChiTietHopDong values('HD014', 'CTHD016', 'x024', 1)
insert into ChiTietHopDong values('HD015', 'CTHD017', 'x022', 1)
insert into ChiTietHopDong values('HD016', 'CTHD018', 'x022', 2)
insert into ChiTietHopDong values('HD017', 'CTHD019', 'x022', 1)
insert into ChiTietHopDong values('HD018', 'CTHD020', 'x002', 1)
insert into ChiTietHopDong values('HD019', 'CTHD021', 'x019', 1)
insert into ChiTietHopDong values('HD020', 'CTHD022', 'x012', 1)
insert into ChiTietHopDong values('HD021', 'CTHD023', 'x013', 4)
insert into ChiTietHopDong values('HD022', 'CTHD024', 'x010', 4)
insert into ChiTietHopDong values('HD023', 'CTHD025', 'x005', 1)
insert into ChiTietHopDong values('HD024', 'CTHD026', 'x007', 1)
insert into ChiTietHopDong values('HD025', 'CTHD027', 'x009', 1)
go

--Thêm dữ liệu trả trực tiếp
insert into TraTrucTiep values('HD001', 0.05, 243200000)
insert into TraTrucTiep values('HD002', 0.02, 32340000)
insert into TraTrucTiep values('HD003', 0.02, 41846000)
insert into TraTrucTiep values('HD004', 0.02, 684000000)
insert into TraTrucTiep values('HD005', 0.02, 44884000)
insert into TraTrucTiep values('HD006', 0.02, 496860000)
insert into TraTrucTiep values('HD007', 0.02, 34202000)
insert into TraTrucTiep values('HD008', 0.02, 111720000)
insert into TraTrucTiep values('HD009', 0.02, 58800000)
insert into TraTrucTiep values('HD011', 0.02, 56987000)
insert into TraTrucTiep values('HD012', 0.05, 201400000)
insert into TraTrucTiep values('HD013', 0.02, 60025000)
insert into TraTrucTiep values('HD014', 0.02, 50960000)
insert into TraTrucTiep values('HD015', 0.02, 46746000)
insert into TraTrucTiep values('HD018', 0.02, 93492000)
insert into TraTrucTiep values('HD019', 0.02, 29204000)
insert into TraTrucTiep values('HD020', 0.02, 44884000)
insert into TraTrucTiep values('HD021', 0.05, 107160000)
insert into TraTrucTiep values('HD022', 0.05, 297120000)
go

--Thêm dữ liệu trả góp
insert into TraGop values('HD010', '2022-2-18 9:00:00.000', 0.01, N'Lê Gia Bảo-0875223476', 8381667)
insert into TraGop values('HD010', '2022-8-18 7:00:00.000', 0.01, N'Lê Gia Bảo-0875223476', 8381667)
insert into TraGop values('HD010', '2023-2-18 14:00:00.000', 0.01, N'Lê Gia Bảo-0875223476', 8381667)

insert into TraGop values('HD016', '2021-5-20 13:00:00.000', 0.005, N'Nguyễn Thị Lan-0862119927', 31833333)
insert into TraGop values('HD016', '2021-11-20 13:00:00.000', 0.005, N'Nguyễn Quang Tài-0913643719(Trả giúp)', 31833333)


insert into TraGop values('HD017', '2021-7-7 7:00:00.000', 0.01, N'Phong Thanh Điền-0780560123', 15916667)


insert into TraGop values('HD023', '2021-12-5 10:30:00.000', 0.015, N'Lê Thanh Nga-0901993517', 11638333)


insert into TraGop values('HD024', '2020-2-4 15:00:00.000', 0.007, N'Nguyễn Văn Viên-0643633577', 18450000)


insert into TraGop values('HD025', '2021-9-4 17:00:00.000', 0.012, N'Nguyễn Thành Được-0710122625', 19116667)


go

--Thêm dữ liệu phiếu bảo hành
insert into PhieuBaoHanh values('BH001', 'HD004', 'Lk007', '2020-7-23 14:00:00.000', N'Phuộc xe bị hỏng', N'Nhà sản xuất', 900000, 'NV022', 'KH004')
insert into PhieuBaoHanh values('BH002', 'HD005', 'LK001', '2021-11-9 15:00:00.000', N'Lốp xe bị hỏng', N'Nhà sản xuất', 1400000, 'NV020', 'KH020')
insert into PhieuBaoHanh values('BH003', 'HD008', 'LK003', '2021-12-8 12:00:00.000', N'Thay đèn xe', N'Đề xuất của khách hàng', 200000, 'NV025', 'KH018')
insert into PhieuBaoHanh values('BH004', 'HD012', 'LK009', '2021-11-30 13:00:00.000', N'Thay nhớt cho xe', N'Đề xuất của khách hàng', 380000, 'NV027', 'KH011')
insert into PhieuBaoHanh values('BH005', 'HD013', 'LK006', '2022-12-19 13:00:00.000', N'Bố thắng bị hỏng', N'Cửa hàng', 200000, 'NV028', 'KH010')
insert into PhieuBaoHanh values('BH006', 'HD015', 'LK012', '2020-12-29 17:00:00.000', N'Thay bộ ốc đĩa', N'Cửa hàng', 160000, 'NV026', 'KH016')
insert into PhieuBaoHanh values('BH007', 'HD020', 'LK004', '2022-4-15 16:00:00.000', N'Xinhan bị hỏng', N'Nhà sản xuất', 470000, 'NV029', 'KH015')
insert into PhieuBaoHanh values('BH008', 'HD021', 'LK011', '2021-2-9 9:00:00.000', N'Kính chiếu hậu bị hỏng', N'Nhà sản xuất', 360000, 'NV030', 'KH013')
go

--Thêm dữ liệu hóa đơn hàng
insert into HoaDonHang values('HDH_N001', 'CH001', '2019-7-4 13:00:00.000')
insert into HoaDonHang values('HDH_N002', 'CH001', '2020-3-8 9:00:00.000')
------------------------------
insert into HoaDonHang values('HDH_X001', 'CH001', '2021-12-16 11:00:00.000')
insert into HoaDonHang values('HDH_X002', 'CH001', '2020-9-8 08:00:00.000')
insert into HoaDonHang values('HDH_X003', 'CH001', '2021-3-4 15:00:00.000')
insert into HoaDonHang values('HDH_X004', 'CH001', '2019-12-28 12:00:00.000')
insert into HoaDonHang values('HDH_X005', 'CH001', '2020-9-5 16:00:00.000')
insert into HoaDonHang values('HDH_X006', 'CH001', '2022-11-1 18:00:00.000')
insert into HoaDonHang values('HDH_X007', 'CH001', '2022-10-21 13:00:00.000')
insert into HoaDonHang values('HDH_X008', 'CH001', '2021-4-15 7:00:00.000')
insert into HoaDonHang values('HDH_X009', 'CH001', '2021-9-9 10:00:00.000')
insert into HoaDonHang values('HDH_X010', 'CH001', '2022-2-18 9:00:00.000')

insert into HoaDonHang values('HDH_N003', 'CH002', '2019-12-4 9:00:00.000')
insert into HoaDonHang values('HDH_N004', 'CH002', '2019-12-13 10:00:00.000')
------------------------------
insert into HoaDonHang values('HDH_X011', 'CH002', '2020-11-26 19:00:00.000')
insert into HoaDonHang values('HDH_X012', 'CH002', '2021-11-3 16:00:00.000')
insert into HoaDonHang values('HDH_X013', 'CH002', '2022-7-4 14:00:00.000')
insert into HoaDonHang values('HDH_X014', 'CH002', '2023-2-2 11:00:00.000')
insert into HoaDonHang values('HDH_X015', 'CH002', '2020-9-19 12:00:00.000')
insert into HoaDonHang values('HDH_X016', 'CH002', '2021-5-20 13:00:00.000')
insert into HoaDonHang values('HDH_X017', 'CH002', '2021-7-7 7:00:00.000')

insert into HoaDonHang values('HDH_N005', 'CH003', '2019-12-3 8:00:00.000')
insert into HoaDonHang values('HDH_N006', 'CH003', '2020-4-6 7:00:00.000')
------------------------------
insert into HoaDonHang values('HDH_X018', 'CH003', '2022-12-8 12:00:00.000')
insert into HoaDonHang values('HDH_X019', 'CH003', '2020-11-24 10:50:00.000')
insert into HoaDonHang values('HDH_X020', 'CH003', '2021-11-15 14:00:00.000')
insert into HoaDonHang values('HDH_X021', 'CH003', '2020-9-15 9:00:00.000')
insert into HoaDonHang values('HDH_X022', 'CH003', '2020-12-1 8:40:00.000')
insert into HoaDonHang values('HDH_X023', 'CH003', '2021-12-5 10:30:00.000')
insert into HoaDonHang values('HDH_X024', 'CH003', '2020-2-4 15:00:00.000')
insert into HoaDonHang values('HDH_X025', 'CH003', '2021-9-4 17:00:00.000')
go

--Thêm dữ liệu phiếu nhập
insert into PhieuNhap values('HDH_N001', N'Công ty cung ứng xe Bảo Long', 'HDH_N001')
insert into PhieuNhap values('HDH_N002', N'Công ty phụ tùng xe Phước Đại', 'HDH_N002')
insert into PhieuNhap values('HDH_N003', N'Công ty cung ứng xe Bảo Long', 'HDH_N003')
insert into PhieuNhap values('HDH_N004', N'Công ty phụ tùng xe Phước Đại', 'HDH_N004')
insert into PhieuNhap values('HDH_N005', N'Công ty cung ứng xe Bảo Long', 'HDH_N005')
insert into PhieuNhap values('HDH_N006', N'Công ty phụ tùng xe Phước Đại', 'HDH_N006')
go

--Thêm dữ liệu phiếu xuất
insert into PhieuXuat values('HDH_X001')
insert into PhieuXuat values('HDH_X002')
insert into PhieuXuat values('HDH_X003')
insert into PhieuXuat values('HDH_X004')
insert into PhieuXuat values('HDH_X005')
insert into PhieuXuat values('HDH_X006')
insert into PhieuXuat values('HDH_X007')
insert into PhieuXuat values('HDH_X008')
insert into PhieuXuat values('HDH_X009')
insert into PhieuXuat values('HDH_X010')
insert into PhieuXuat values('HDH_X011')
insert into PhieuXuat values('HDH_X012')
insert into PhieuXuat values('HDH_X013')
insert into PhieuXuat values('HDH_X014')
insert into PhieuXuat values('HDH_X015')
insert into PhieuXuat values('HDH_X016')
insert into PhieuXuat values('HDH_X017')
insert into PhieuXuat values('HDH_X018')
insert into PhieuXuat values('HDH_X019')
insert into PhieuXuat values('HDH_X020')
insert into PhieuXuat values('HDH_X021')
insert into PhieuXuat values('HDH_X022')
insert into PhieuXuat values('HDH_X023')
insert into PhieuXuat values('HDH_X024')
insert into PhieuXuat values('HDH_X025')
go

--Thêm dữ liệu chi tiết hóa đơn hàng
insert into ChiTietHoaDonHang values('HDH_N001','X001',2)
insert into ChiTietHoaDonHang values('HDH_N001','X002',2)
insert into ChiTietHoaDonHang values('HDH_N001','X003',4)
insert into ChiTietHoaDonHang values('HDH_N001','X004',7)
insert into ChiTietHoaDonHang values('HDH_N001','X005',7)
insert into ChiTietHoaDonHang values('HDH_N001','X006',6)
insert into ChiTietHoaDonHang values('HDH_N001','X007',8)
insert into ChiTietHoaDonHang values('HDH_N001','X008',5)
insert into ChiTietHoaDonHang values('HDH_N001','X009',3)
insert into ChiTietHoaDonHang values('HDH_N001','X010',3)
insert into ChiTietHoaDonHang values('HDH_N001','X011',1)
insert into ChiTietHoaDonHang values('HDH_N001','X012',6)
insert into ChiTietHoaDonHang values('HDH_N001','X013',5)
insert into ChiTietHoaDonHang values('HDH_N001','X014',3)
insert into ChiTietHoaDonHang values('HDH_N001','X015',2)
insert into ChiTietHoaDonHang values('HDH_N001','X016',10)
insert into ChiTietHoaDonHang values('HDH_N001','X017',6)
insert into ChiTietHoaDonHang values('HDH_N001','X018',5)
insert into ChiTietHoaDonHang values('HDH_N001','X019',6)
insert into ChiTietHoaDonHang values('HDH_N001','X020',3)
insert into ChiTietHoaDonHang values('HDH_N001','X021',2)
insert into ChiTietHoaDonHang values('HDH_N001','X022',5)
insert into ChiTietHoaDonHang values('HDH_N001','X023',2)
insert into ChiTietHoaDonHang values('HDH_N001','X024',2)
insert into ChiTietHoaDonHang values('HDH_N001','X025',1)
insert into ChiTietHoaDonHang values('HDH_N002','LK001',2)
insert into ChiTietHoaDonHang values('HDH_N002','LK002',10)
insert into ChiTietHoaDonHang values('HDH_N002','LK003',7)
insert into ChiTietHoaDonHang values('HDH_N002','LK004',13)
insert into ChiTietHoaDonHang values('HDH_N002','LK005',7)
insert into ChiTietHoaDonHang values('HDH_N002','LK006',15)
insert into ChiTietHoaDonHang values('HDH_N002','LK007',12)
insert into ChiTietHoaDonHang values('HDH_N002','LK008',18)
insert into ChiTietHoaDonHang values('HDH_N002','LK009',15)
insert into ChiTietHoaDonHang values('HDH_N002','LK010',13)
insert into ChiTietHoaDonHang values('HDH_N002','LK011',30)
insert into ChiTietHoaDonHang values('HDH_N002','LK012',10)

insert into ChiTietHoaDonHang values('HDH_N003','X001',2)
insert into ChiTietHoaDonHang values('HDH_N003','X002',2)
insert into ChiTietHoaDonHang values('HDH_N003','X003',4)
insert into ChiTietHoaDonHang values('HDH_N003','X004',7)
insert into ChiTietHoaDonHang values('HDH_N003','X005',7)
insert into ChiTietHoaDonHang values('HDH_N003','X006',5)
insert into ChiTietHoaDonHang values('HDH_N003','X007',8)
insert into ChiTietHoaDonHang values('HDH_N003','X008',5)
insert into ChiTietHoaDonHang values('HDH_N003','X009',3)
insert into ChiTietHoaDonHang values('HDH_N003','X010',2)
insert into ChiTietHoaDonHang values('HDH_N003','X011',2)
insert into ChiTietHoaDonHang values('HDH_N003','X012',5)
insert into ChiTietHoaDonHang values('HDH_N003','X013',6)
insert into ChiTietHoaDonHang values('HDH_N003','X014',3)
insert into ChiTietHoaDonHang values('HDH_N003','X015',2)
insert into ChiTietHoaDonHang values('HDH_N003','X016',5)
insert into ChiTietHoaDonHang values('HDH_N003','X017',6)
insert into ChiTietHoaDonHang values('HDH_N003','X018',5)
insert into ChiTietHoaDonHang values('HDH_N003','X019',5)
insert into ChiTietHoaDonHang values('HDH_N003','X020',4)
insert into ChiTietHoaDonHang values('HDH_N003','X021',2)
insert into ChiTietHoaDonHang values('HDH_N003','X022',6)
insert into ChiTietHoaDonHang values('HDH_N003','X023',2)
insert into ChiTietHoaDonHang values('HDH_N003','X024',2)
insert into ChiTietHoaDonHang values('HDH_N003','X025',2)
insert into ChiTietHoaDonHang values('HDH_N004','LK001',2)
insert into ChiTietHoaDonHang values('HDH_N004','LK002',7)
insert into ChiTietHoaDonHang values('HDH_N004','LK003',5)
insert into ChiTietHoaDonHang values('HDH_N004','LK004',11)
insert into ChiTietHoaDonHang values('HDH_N004','LK005',6)
insert into ChiTietHoaDonHang values('HDH_N004','LK006',15)
insert into ChiTietHoaDonHang values('HDH_N004','LK007',12)
insert into ChiTietHoaDonHang values('HDH_N004','LK008',18)
insert into ChiTietHoaDonHang values('HDH_N004','LK009',15)
insert into ChiTietHoaDonHang values('HDH_N004','LK010',13)
insert into ChiTietHoaDonHang values('HDH_N004','LK011',30)
insert into ChiTietHoaDonHang values('HDH_N004','LK012',10)

insert into ChiTietHoaDonHang values('HDH_N005','X001',2)
insert into ChiTietHoaDonHang values('HDH_N005','X002',2)
insert into ChiTietHoaDonHang values('HDH_N005','X003',4)
insert into ChiTietHoaDonHang values('HDH_N005','X004',3)
insert into ChiTietHoaDonHang values('HDH_N005','X005',7)
insert into ChiTietHoaDonHang values('HDH_N005','X006',5)
insert into ChiTietHoaDonHang values('HDH_N005','X007',8)
insert into ChiTietHoaDonHang values('HDH_N005','X008',4)
insert into ChiTietHoaDonHang values('HDH_N005','X009',4)
insert into ChiTietHoaDonHang values('HDH_N005','X010',2)
insert into ChiTietHoaDonHang values('HDH_N005','X011',1)
insert into ChiTietHoaDonHang values('HDH_N005','X012',5)
insert into ChiTietHoaDonHang values('HDH_N005','X013',6)
insert into ChiTietHoaDonHang values('HDH_N005','X014',3)
insert into ChiTietHoaDonHang values('HDH_N005','X015',2)
insert into ChiTietHoaDonHang values('HDH_N005','X016',8)
insert into ChiTietHoaDonHang values('HDH_N005','X017',6)
insert into ChiTietHoaDonHang values('HDH_N005','X018',4)
insert into ChiTietHoaDonHang values('HDH_N005','X019',6)
insert into ChiTietHoaDonHang values('HDH_N005','X020',3)
insert into ChiTietHoaDonHang values('HDH_N005','X021',3)
insert into ChiTietHoaDonHang values('HDH_N005','X022',6)
insert into ChiTietHoaDonHang values('HDH_N005','X023',2)
insert into ChiTietHoaDonHang values('HDH_N005','X024',3)
insert into ChiTietHoaDonHang values('HDH_N005','X025',2)
insert into ChiTietHoaDonHang values('HDH_N006','LK001',4)
insert into ChiTietHoaDonHang values('HDH_N006','LK002',5)
insert into ChiTietHoaDonHang values('HDH_N006','LK003',5)
insert into ChiTietHoaDonHang values('HDH_N006','LK004',9)
insert into ChiTietHoaDonHang values('HDH_N006','LK005',6)
insert into ChiTietHoaDonHang values('HDH_N006','LK006',15)
insert into ChiTietHoaDonHang values('HDH_N006','LK007',12)
insert into ChiTietHoaDonHang values('HDH_N006','LK008',18)
insert into ChiTietHoaDonHang values('HDH_N006','LK009',15)
insert into ChiTietHoaDonHang values('HDH_N006','LK010',13)
insert into ChiTietHoaDonHang values('HDH_N006','LK011',30)
insert into ChiTietHoaDonHang values('HDH_N006','LK012',9)

insert into ChiTietHoaDonHang values('HDH_X001','X002',1)
insert into ChiTietHoaDonHang values('HDH_X001','X004',1)
insert into ChiTietHoaDonHang values('HDH_X002','X006',1)
insert into ChiTietHoaDonHang values('HDH_X003','X007',1)
insert into ChiTietHoaDonHang values('HDH_X003','X008',1)
insert into ChiTietHoaDonHang values('HDH_X004','X011',1)
insert into ChiTietHoaDonHang values('HDH_X005','X012',1)
insert into ChiTietHoaDonHang values('HDH_X006','X014',1)
insert into ChiTietHoaDonHang values('HDH_X007','X005',1)
insert into ChiTietHoaDonHang values('HDH_X008','X009',2)
insert into ChiTietHoaDonHang values('HDH_X009','X016',2)
insert into ChiTietHoaDonHang values('HDH_X010','X017',1)
insert into ChiTietHoaDonHang values('HDH_X011','X018',1)
insert into ChiTietHoaDonHang values('HDH_X012','X020',1)
insert into ChiTietHoaDonHang values('HDH_X013','X025',1)
insert into ChiTietHoaDonHang values('HDH_X014','X024',1)
insert into ChiTietHoaDonHang values('HDH_X015','X022',1)
insert into ChiTietHoaDonHang values('HDH_X016','X022',2)
insert into ChiTietHoaDonHang values('HDH_X017','X022',1)
insert into ChiTietHoaDonHang values('HDH_X018','X002',1)
insert into ChiTietHoaDonHang values('HDH_X019','X019',1)
insert into ChiTietHoaDonHang values('HDH_X020','X012',1)
insert into ChiTietHoaDonHang values('HDH_X021','X013',2)
insert into ChiTietHoaDonHang values('HDH_X022','X010',1)
insert into ChiTietHoaDonHang values('HDH_X023','X005',1)
insert into ChiTietHoaDonHang values('HDH_X024','X007',3)
insert into ChiTietHoaDonHang values('HDH_X025','X009',1)
go

----Truy xuất
--select * from MatHang
--select * from Xe
--select * from LinhKienPhuTung
--select * from NhanVien
--select * from NV_HanhChinh 
--select * from NV_KyThuat
--select * from CuaHang
--select * from KhachHang
--select * from HopDong
--select * from TraGop
--select * from TraTrucTiep
--select * from ChiTietHopDong 
--select * from PhieuBaoHanh
--select * from HoaDonHang
--select * from ChiTietHoaDonHang
--select * from PhieuNhap
--select * from PhieuXuat
--go
