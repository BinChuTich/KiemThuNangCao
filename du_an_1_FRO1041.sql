use master
go
IF EXISTS ( SELECT name
                FROM sys.databases
                WHERE name = N'du_an_1_FRO1041' )
    DROP DATABASE du_an_1_FRO1041
create database du_an_1_FRO1041
go
-- Drop the database if it already exists

use du_an_1_FRO1041
go

create table Loai_phong(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma varchar(10) UNIQUE,
	Ten nvarchar(50),
	DienTich float,
	GiaTien float
);
go
create table Phong_tro(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	MaPhong varchar(10) UNIQUE,
	TenPhong nvarchar(50),
	SoTang int,
	TrangThai bit,
	MoTa nvarchar(250),
	IDLoaiPhong UNIQUEIDENTIFIER,
	IDKhachHang UNIQUEIDENTIFIER
);
go
create table Khach_hang(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	MaKH varchar(10) UNIQUE,
	TenKH nvarchar(50),
	CCCD varchar(20),
	NgaySinh Date,
	Email nvarchar(50),
	SDT varchar(20),
	GioiTinh bit,
	DiaChi nvarchar(50)
);
go
create table Hoadon_phong(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma varchar(10) UNIQUE,
	Thang int,
	NgayTao Date,
	TongTien float,
	TrangThai bit,
	IDPhongTro UNIQUEIDENTIFIER,
	IDKhachHang UNIQUEIDENTIFIER,
	IDHopDong UNIQUEIDENTIFIER
);
go
create table Hoadon_dien_nuoc(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma varchar(10) UNIQUE,
	SoDien int,
	SoNuoc int,
	TongTien float,
	NgayTao Date,
	TrangThai bit,
	IDPhongTro UNIQUEIDENTIFIER,
	IDKhachHang UNIQUEIDENTIFIER,
	IDHopDong UNIQUEIDENTIFIER
);
go
create table Hop_dong(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	Ma varchar(10) UNIQUE,
	TienCoc float,
	GiaPhong float,
	GiaDien float,
	GiaNuoc float,
	NgayTao Date,
	NgayKetThuc Date,
	ThoiGianNopTien int,
	IDPhongTro UNIQUEIDENTIFIER,
	IDKhachHang UNIQUEIDENTIFIER
);
go
create table Hop_dong_ts(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	IDHopDong UNIQUEIDENTIFIER,
	IdTaiSan UNIQUEIDENTIFIER,
	soLuong int
)
go
create table Tai_san(
	Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	MaTS varchar(10) UNIQUE,
	TenTS nvarchar(50),
	Gia float,
	SoLuong int
);
go
--TẠO QUAN HỆ GIỮA CÁC BẢNG
--Phòng trọ - Loại phòng
ALTER TABLE Phong_tro ADD FOREIGN KEY (IDLoaiPhong) REFERENCES Loai_phong(Id) 
--Hợp đồng - phòng trọ
ALTER TABLE Hop_dong ADD FOREIGN KEY (IDPhongTro) REFERENCES Phong_tro(Id) 
--Hop dong - Khach hang
ALTER TABLE Hop_dong ADD FOREIGN KEY (IDKhachHang) REFERENCES Khach_hang(Id) 
-- Hop dong ts - Hop dong
ALTER TABLE Hop_dong_ts ADD FOREIGN KEY (IDHopDong) REFERENCES Hop_dong(Id) 
-- Hop dong ts - Tai san
ALTER TABLE Hop_dong_ts ADD FOREIGN KEY (IdTaiSan) REFERENCES Tai_san(Id) 
--Hoa don tien phong - Phong tro
ALTER TABLE Hoadon_phong ADD FOREIGN KEY (IDPhongTro) REFERENCES Phong_tro(Id) 
--Hoa don tien phong  - Khach hang
ALTER TABLE Hoadon_phong ADD FOREIGN KEY (IDKhachHang) REFERENCES Khach_hang(Id) 
--Hoa don tien phong - Hop dong
ALTER TABLE Hoadon_phong ADD FOREIGN KEY (IDHopDong) REFERENCES Hop_dong(Id)
--Hoa don dien nuoc - Phong tro
ALTER TABLE Hoadon_dien_nuoc ADD FOREIGN KEY (IDPhongTro) REFERENCES Phong_tro(Id) 
--Hoa don dien nuoc  - Khach hang
ALTER TABLE Hoadon_dien_nuoc ADD FOREIGN KEY (IDKhachHang) REFERENCES Khach_hang(Id) 
--Hoa don dien nuoc - Hop dong
ALTER TABLE Hoadon_dien_nuoc ADD FOREIGN KEY (IDHopDong) REFERENCES Hop_dong(Id) 
--PhongTro - KhachHang
ALTER TABLE Phong_tro ADD FOREIGN KEY (IDKhachHang) REFERENCES Khach_hang(Id) 


select *from Khach_hang

delete Khach_hang where id = '60EBD2F0-9037-45D3-A829-FA5D023C554D'