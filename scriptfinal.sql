USE [QuanLiThongTinCovid]
GO
ALTER TABLE [dbo].[thong_tin_khai_bao] DROP CONSTRAINT [fk_ttkbao_nk]
GO
ALTER TABLE [dbo].[thong_tin_cach_li] DROP CONSTRAINT [fk_ttcl_nk]
GO
ALTER TABLE [dbo].[nhan_khau] DROP CONSTRAINT [fk_nk_hogd]
GO
ALTER TABLE [dbo].[ket_qua_test] DROP CONSTRAINT [fk_kq]
GO
ALTER TABLE [dbo].[cach_ly_ho_GD] DROP CONSTRAINT [fk_ma_ho_cach_ly]
GO
/****** Object:  Table [dbo].[thong_tin_khai_bao]    Script Date: 12/22/2020 1:49:58 AM ******/
DROP TABLE [dbo].[thong_tin_khai_bao]
GO
/****** Object:  Table [dbo].[thong_tin_cach_li]    Script Date: 12/22/2020 1:49:58 AM ******/
DROP TABLE [dbo].[thong_tin_cach_li]
GO
/****** Object:  Table [dbo].[nhan_khau]    Script Date: 12/22/2020 1:49:58 AM ******/
DROP TABLE [dbo].[nhan_khau]
GO
/****** Object:  Table [dbo].[ket_qua_test]    Script Date: 12/22/2020 1:49:58 AM ******/
DROP TABLE [dbo].[ket_qua_test]
GO
/****** Object:  Table [dbo].[ho_gia_dinh]    Script Date: 12/22/2020 1:49:58 AM ******/
DROP TABLE [dbo].[ho_gia_dinh]
GO
/****** Object:  Table [dbo].[cach_ly_ho_GD]    Script Date: 12/22/2020 1:49:58 AM ******/
DROP TABLE [dbo].[cach_ly_ho_GD]
GO
/****** Object:  Table [dbo].[cach_ly_ho_GD]    Script Date: 12/22/2020 1:49:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cach_ly_ho_GD](
	[ma_ho_gd] [char](5) NOT NULL,
	[thoi_gian_bat_dau] [datetime] NOT NULL,
	[muc_do_cach_ly] [char](2) NOT NULL,
	[dia_diem_cach_ly] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_ho_gd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ho_gia_dinh]    Script Date: 12/22/2020 1:49:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ho_gia_dinh](
	[ma_ho_gd] [char](5) NOT NULL,
	[dia_chi] [nvarchar](100) NOT NULL,
	[chu_ho] [nvarchar](100) NOT NULL,
	[so_thanh_vien] [smallint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_ho_gd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ket_qua_test]    Script Date: 12/22/2020 1:49:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ket_qua_test](
	[ma_so_cach_ly] [int] NOT NULL,
	[thoi_gian_test] [date] NOT NULL,
	[ket_qua_test] [bit] NOT NULL,
	[lan_test] [int] NOT NULL,
 CONSTRAINT [PK__ket_qua___317EFB541175E856] PRIMARY KEY CLUSTERED 
(
	[ma_so_cach_ly] ASC,
	[lan_test] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nhan_khau]    Script Date: 12/22/2020 1:49:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhan_khau](
	[ID_nhan_khau] [int] IDENTITY(1,1) NOT NULL,
	[so_CMND] [decimal](9, 0) NULL,
	[ma_ho_gd] [char](5) NOT NULL,
	[noi_lam_viec] [nvarchar](100) NOT NULL,
	[so_DT] [varchar](10) NULL,
	[ho_ten] [nvarchar](100) NOT NULL,
	[ngay_sinh] [date] NULL,
	[gioi_tinh] [nvarchar](5) NULL,
 CONSTRAINT [PK_nhan_khau] PRIMARY KEY CLUSTERED 
(
	[ID_nhan_khau] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[thong_tin_cach_li]    Script Date: 12/22/2020 1:49:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[thong_tin_cach_li](
	[ma_so_cach_ly] [int] IDENTITY(1,1) NOT NULL,
	[thoi_gian_bat_dau] [date] NOT NULL,
	[muc_do_cach_ly] [char](2) NOT NULL,
	[da_test_covid] [bit] NOT NULL,
	[ID_nhan_khau] [int] NOT NULL,
	[thoi_gian_ket_thuc] [date] NULL,
	[noi_cach_ly] [nvarchar](100) NULL,
 CONSTRAINT [PK__thong_ti__317EFB5404153AB1] PRIMARY KEY CLUSTERED 
(
	[ma_so_cach_ly] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[thong_tin_khai_bao]    Script Date: 12/22/2020 1:49:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[thong_tin_khai_bao](
	[ma_khai_bao] [varchar](10) NOT NULL,
	[ID_nhan_khau] [int] NOT NULL,
	[tinh_trang_sk] [nvarchar](100) NOT NULL,
	[thoi_gian_khai_bao] [date] NULL,
	[lich_su_di_lai] [nvarchar](200) NULL,
 CONSTRAINT [PK_thong_tin_khai_bao_1] PRIMARY KEY CLUSTERED 
(
	[ma_khai_bao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ho_gia_dinh] ([ma_ho_gd], [dia_chi], [chu_ho], [so_thanh_vien]) VALUES (N'A0001', N'HA NOI', N'NGUYEN VAN A', 4)
INSERT [dbo].[ho_gia_dinh] ([ma_ho_gd], [dia_chi], [chu_ho], [so_thanh_vien]) VALUES (N'A0002', N'HA NOI', N'NGUYEN VAN B', 5)
INSERT [dbo].[ho_gia_dinh] ([ma_ho_gd], [dia_chi], [chu_ho], [so_thanh_vien]) VALUES (N'A0003', N'HA NOI', N'LE XUAN A', 3)
INSERT [dbo].[ho_gia_dinh] ([ma_ho_gd], [dia_chi], [chu_ho], [so_thanh_vien]) VALUES (N'A0004', N'HA NOI', N'LE XUAN B', 5)
INSERT [dbo].[ho_gia_dinh] ([ma_ho_gd], [dia_chi], [chu_ho], [so_thanh_vien]) VALUES (N'A0005', N'HA NOI', N'LA MINH TOAN', 4)
INSERT [dbo].[ho_gia_dinh] ([ma_ho_gd], [dia_chi], [chu_ho], [so_thanh_vien]) VALUES (N'A0006', N'HA NOI ', N'CAO VAN A', 4)
INSERT [dbo].[ho_gia_dinh] ([ma_ho_gd], [dia_chi], [chu_ho], [so_thanh_vien]) VALUES (N'A0007', N'HA NOI', N'CAO VAN B', 5)
INSERT [dbo].[ho_gia_dinh] ([ma_ho_gd], [dia_chi], [chu_ho], [so_thanh_vien]) VALUES (N'A0008', N'HA NOI', N'BUI THI A', 3)
INSERT [dbo].[ho_gia_dinh] ([ma_ho_gd], [dia_chi], [chu_ho], [so_thanh_vien]) VALUES (N'A0009', N'HA NOI', N'BUI VAN B', 4)
INSERT [dbo].[ho_gia_dinh] ([ma_ho_gd], [dia_chi], [chu_ho], [so_thanh_vien]) VALUES (N'A0010', N'HA NOI', N'LE VAN G', 5)
INSERT [dbo].[ket_qua_test] ([ma_so_cach_ly], [thoi_gian_test], [ket_qua_test], [lan_test]) VALUES (2, CAST(N'2020-05-14' AS Date), 1, 1)
INSERT [dbo].[ket_qua_test] ([ma_so_cach_ly], [thoi_gian_test], [ket_qua_test], [lan_test]) VALUES (2, CAST(N'2020-05-19' AS Date), 1, 2)
INSERT [dbo].[ket_qua_test] ([ma_so_cach_ly], [thoi_gian_test], [ket_qua_test], [lan_test]) VALUES (2, CAST(N'2020-05-21' AS Date), 0, 3)
INSERT [dbo].[ket_qua_test] ([ma_so_cach_ly], [thoi_gian_test], [ket_qua_test], [lan_test]) VALUES (2, CAST(N'2020-05-31' AS Date), 0, 4)
INSERT [dbo].[ket_qua_test] ([ma_so_cach_ly], [thoi_gian_test], [ket_qua_test], [lan_test]) VALUES (2, CAST(N'2020-06-11' AS Date), 0, 5)
INSERT [dbo].[ket_qua_test] ([ma_so_cach_ly], [thoi_gian_test], [ket_qua_test], [lan_test]) VALUES (5, CAST(N'2020-10-10' AS Date), 1, 1)
INSERT [dbo].[ket_qua_test] ([ma_so_cach_ly], [thoi_gian_test], [ket_qua_test], [lan_test]) VALUES (5, CAST(N'2020-10-13' AS Date), 1, 2)
SET IDENTITY_INSERT [dbo].[nhan_khau] ON 

INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (1, CAST(154151514 AS Decimal(9, 0)), N'A0002', N'Hà nội', N'125645126', N'Nguyễn Văn A', CAST(N'1990-06-03' AS Date), N'Nam')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (2, CAST(511939418 AS Decimal(9, 0)), N'A0002', N'Hà nội', N'125645126', N'Nguyễn Văn An', CAST(N'1990-06-03' AS Date), N'Nam')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (3, CAST(357224262 AS Decimal(9, 0)), N'A0002', N'Hà nội', N'674633525', N'Nguyễn Văn Am', CAST(N'1990-06-03' AS Date), N'Nam')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (4, CAST(154236457 AS Decimal(9, 0)), N'A0003', N'Hà nội', N'673634635', N'Nguyễn Văn B', CAST(N'1990-06-03' AS Date), N'Nam')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (5, CAST(200003141 AS Decimal(9, 0)), N'A0003', N'Hà nội', N'161351414', N'Lê Xuân Vinh', CAST(N'1990-06-03' AS Date), N'Nam')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (6, CAST(154236457 AS Decimal(9, 0)), N'A0003', N'Hà nội', N'125645126', N'Nguyễn Văn Ban', CAST(N'1990-06-03' AS Date), N'Nam')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (7, CAST(125645892 AS Decimal(9, 0)), N'A0004', N'Hòa Bình', N'126458941', N'Tran Thi B', CAST(N'1986-12-05' AS Date), N'Nữ')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (8, CAST(561254695 AS Decimal(9, 0)), N'A0004', N'Hòa Bình', N'126458941', N'Trần Thị Phương', CAST(N'1986-10-05' AS Date), N'Nữ')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (9, CAST(561254695 AS Decimal(9, 0)), N'A0004', N'Hòa Bình', N'126450000', N'Trần Thị Hương', CAST(N'1990-10-05' AS Date), N'Nữ')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (12, CAST(129370183 AS Decimal(9, 0)), N'A0005', N'Ninh Bình', N'12817278', N'Ngô Thị Quế', CAST(N'1950-10-14' AS Date), N'Nữ')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (13, CAST(461613236 AS Decimal(9, 0)), N'A0005', N'Ninh Bình', N'19526316', N'Ngô Thị Trinh', CAST(N'1960-12-05' AS Date), N'Nữ')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (14, CAST(195719279 AS Decimal(9, 0)), N'A0005', N'Thanh Hóa', N'131549663', N'Mai Lan Hưng', CAST(N'1976-12-12' AS Date), N'Nữ')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (15, CAST(645213154 AS Decimal(9, 0)), N'A0006', N'Quảng Ninh', N'156486403', N'Lê Hoàng Quân', CAST(N'1980-02-03' AS Date), N'Nam')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (16, CAST(841613125 AS Decimal(9, 0)), N'A0006', N'Quảng Ninh', N'154684132', N'Ngô Song Huấn', CAST(N'1956-05-06' AS Date), N'Nam')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (17, CAST(784164513 AS Decimal(9, 0)), N'A0006', N'Sơn La', N'141615131', N'Lê Quang Tèo', CAST(N'1987-02-06' AS Date), N'Nam')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (18, CAST(749161625 AS Decimal(9, 0)), N'A0007', N'Thanh Hóa', N'164613233', N'Ngô Linh Đàm', CAST(N'1965-08-07' AS Date), N'Nữ')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (23, CAST(484161613 AS Decimal(9, 0)), N'A0007', N'Sơn La', N'154613201', N'Lê Thị Thúy', CAST(N'1956-03-01' AS Date), N'Nữ')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (25, CAST(214827917 AS Decimal(9, 0)), N'A0007', N'Hà Tây', N'165468431', N'Đàm Vĩnh Tuy', CAST(N'1967-05-09' AS Date), N'Nam')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (26, CAST(85098029 AS Decimal(9, 0)), N'A0008', N'Hà nội', N'164631354', N'Lê Thị Hồng', CAST(N'1956-08-09' AS Date), N'Nữ')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (28, CAST(823957291 AS Decimal(9, 0)), N'A0008', N'Hà nội', N'164733659', N'Lại Thị Huệ', CAST(N'1978-04-01' AS Date), N'Nữ')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (29, CAST(927591387 AS Decimal(9, 0)), N'A0008', N'Hà Tây', N'398571928', N'Lê Xuân Dũng', CAST(N'1989-01-02' AS Date), N'Nam')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (30, CAST(791791928 AS Decimal(9, 0)), N'A0009', N'Bắc Ninh', N'165463133', N'Lê Quang Huân', CAST(N'1959-05-06' AS Date), N'Nam')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (31, CAST(93208028 AS Decimal(9, 0)), N'A0009', N'Thanh Hóa', N'116513133', N'Ngô Văn Kiên', CAST(N'1987-05-06' AS Date), N'Nam')
INSERT [dbo].[nhan_khau] ([ID_nhan_khau], [so_CMND], [ma_ho_gd], [noi_lam_viec], [so_DT], [ho_ten], [ngay_sinh], [gioi_tinh]) VALUES (32, CAST(218749127 AS Decimal(9, 0)), N'A0010', N'Bắc Ninh', N'241249817', N'Lại Thị Thơ', CAST(N'1965-05-06' AS Date), N'Nữ')
SET IDENTITY_INSERT [dbo].[nhan_khau] OFF
SET IDENTITY_INSERT [dbo].[thong_tin_cach_li] ON 

INSERT [dbo].[thong_tin_cach_li] ([ma_so_cach_ly], [thoi_gian_bat_dau], [muc_do_cach_ly], [da_test_covid], [ID_nhan_khau], [thoi_gian_ket_thuc], [noi_cach_ly]) VALUES (1, CAST(N'2020-06-02' AS Date), N'F2', 0, 5, NULL, N'Hà Nội')
INSERT [dbo].[thong_tin_cach_li] ([ma_so_cach_ly], [thoi_gian_bat_dau], [muc_do_cach_ly], [da_test_covid], [ID_nhan_khau], [thoi_gian_ket_thuc], [noi_cach_ly]) VALUES (2, CAST(N'2020-05-06' AS Date), N'F2', 1, 4, CAST(N'2020-06-18' AS Date), N'Lạng Sơn')
INSERT [dbo].[thong_tin_cach_li] ([ma_so_cach_ly], [thoi_gian_bat_dau], [muc_do_cach_ly], [da_test_covid], [ID_nhan_khau], [thoi_gian_ket_thuc], [noi_cach_ly]) VALUES (3, CAST(N'2020-09-04' AS Date), N'F3', 0, 6, NULL, N'Hòa Bình')
INSERT [dbo].[thong_tin_cach_li] ([ma_so_cach_ly], [thoi_gian_bat_dau], [muc_do_cach_ly], [da_test_covid], [ID_nhan_khau], [thoi_gian_ket_thuc], [noi_cach_ly]) VALUES (4, CAST(N'2020-09-02' AS Date), N'F1', 0, 32, NULL, N'Bắc Ninh')
INSERT [dbo].[thong_tin_cach_li] ([ma_so_cach_ly], [thoi_gian_bat_dau], [muc_do_cach_ly], [da_test_covid], [ID_nhan_khau], [thoi_gian_ket_thuc], [noi_cach_ly]) VALUES (5, CAST(N'2020-10-08' AS Date), N'F2', 1, 7, NULL, N'Hòa Bình')
INSERT [dbo].[thong_tin_cach_li] ([ma_so_cach_ly], [thoi_gian_bat_dau], [muc_do_cach_ly], [da_test_covid], [ID_nhan_khau], [thoi_gian_ket_thuc], [noi_cach_ly]) VALUES (6, CAST(N'2020-03-04' AS Date), N'F1', 0, 8, NULL, N'Sơn La')
SET IDENTITY_INSERT [dbo].[thong_tin_cach_li] OFF
INSERT [dbo].[thong_tin_khai_bao] ([ma_khai_bao], [ID_nhan_khau], [tinh_trang_sk], [thoi_gian_khai_bao], [lich_su_di_lai]) VALUES (N'a175', 25, N'Yếu', CAST(N'2020-09-27' AS Date), N'Hà nội')
INSERT [dbo].[thong_tin_khai_bao] ([ma_khai_bao], [ID_nhan_khau], [tinh_trang_sk], [thoi_gian_khai_bao], [lich_su_di_lai]) VALUES (N'a515', 13, N'Yếu', CAST(N'2020-10-01' AS Date), N'Thanh Hóa')
INSERT [dbo].[thong_tin_khai_bao] ([ma_khai_bao], [ID_nhan_khau], [tinh_trang_sk], [thoi_gian_khai_bao], [lich_su_di_lai]) VALUES (N'a890', 31, N'Yếu', CAST(N'2020-09-30' AS Date), N'Thanh Hóa')
INSERT [dbo].[thong_tin_khai_bao] ([ma_khai_bao], [ID_nhan_khau], [tinh_trang_sk], [thoi_gian_khai_bao], [lich_su_di_lai]) VALUES (N'S015', 31, N'Bình thường', CAST(N'2020-07-09' AS Date), N'TP Hồ Chí Minh')
INSERT [dbo].[thong_tin_khai_bao] ([ma_khai_bao], [ID_nhan_khau], [tinh_trang_sk], [thoi_gian_khai_bao], [lich_su_di_lai]) VALUES (N's098', 7, N'', CAST(N'2020-09-25' AS Date), N'Hà Nội')
INSERT [dbo].[thong_tin_khai_bao] ([ma_khai_bao], [ID_nhan_khau], [tinh_trang_sk], [thoi_gian_khai_bao], [lich_su_di_lai]) VALUES (N's106', 9, N'Bình thường', CAST(N'2020-10-05' AS Date), N'Lạng Sơn')
INSERT [dbo].[thong_tin_khai_bao] ([ma_khai_bao], [ID_nhan_khau], [tinh_trang_sk], [thoi_gian_khai_bao], [lich_su_di_lai]) VALUES (N's871', 3, N'Bình thường', CAST(N'2020-09-20' AS Date), N'Hà nội')
INSERT [dbo].[thong_tin_khai_bao] ([ma_khai_bao], [ID_nhan_khau], [tinh_trang_sk], [thoi_gian_khai_bao], [lich_su_di_lai]) VALUES (N'T123', 15, N'Ốm ,ho', CAST(N'2020-06-13' AS Date), N'Kiên Giang')
INSERT [dbo].[thong_tin_khai_bao] ([ma_khai_bao], [ID_nhan_khau], [tinh_trang_sk], [thoi_gian_khai_bao], [lich_su_di_lai]) VALUES (N'test', 2, N'ốm ,ho', CAST(N'2020-08-11' AS Date), N'TP Hồ Chí Minh')
ALTER TABLE [dbo].[cach_ly_ho_GD]  WITH CHECK ADD  CONSTRAINT [fk_ma_ho_cach_ly] FOREIGN KEY([ma_ho_gd])
REFERENCES [dbo].[ho_gia_dinh] ([ma_ho_gd])
GO
ALTER TABLE [dbo].[cach_ly_ho_GD] CHECK CONSTRAINT [fk_ma_ho_cach_ly]
GO
ALTER TABLE [dbo].[ket_qua_test]  WITH CHECK ADD  CONSTRAINT [fk_kq] FOREIGN KEY([ma_so_cach_ly])
REFERENCES [dbo].[thong_tin_cach_li] ([ma_so_cach_ly])
GO
ALTER TABLE [dbo].[ket_qua_test] CHECK CONSTRAINT [fk_kq]
GO
ALTER TABLE [dbo].[nhan_khau]  WITH CHECK ADD  CONSTRAINT [fk_nk_hogd] FOREIGN KEY([ma_ho_gd])
REFERENCES [dbo].[ho_gia_dinh] ([ma_ho_gd])
GO
ALTER TABLE [dbo].[nhan_khau] CHECK CONSTRAINT [fk_nk_hogd]
GO
ALTER TABLE [dbo].[thong_tin_cach_li]  WITH CHECK ADD  CONSTRAINT [fk_ttcl_nk] FOREIGN KEY([ID_nhan_khau])
REFERENCES [dbo].[nhan_khau] ([ID_nhan_khau])
GO
ALTER TABLE [dbo].[thong_tin_cach_li] CHECK CONSTRAINT [fk_ttcl_nk]
GO
ALTER TABLE [dbo].[thong_tin_khai_bao]  WITH CHECK ADD  CONSTRAINT [fk_ttkbao_nk] FOREIGN KEY([ID_nhan_khau])
REFERENCES [dbo].[nhan_khau] ([ID_nhan_khau])
GO
ALTER TABLE [dbo].[thong_tin_khai_bao] CHECK CONSTRAINT [fk_ttkbao_nk]
GO
